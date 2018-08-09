package tds.packager.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

import org.apache.commons.lang3.tuple.Pair;

public class ColumnUtil {
    private static boolean isVar(final String name, final Pair<String, String> pair) {
        return pair.getLeft().toLowerCase().startsWith(name.toLowerCase());
    }

    /**
     * Removes name/value pairs until the given pair name matches
     * Returns the remaining list
     */
    private static List<Pair<String, String>> slurp(final String name, final Iterator<Pair<String, String>> iterator) {
        final List<Pair<String, String>> newColumn = new ArrayList<Pair<String, String>>();
        // remove pairs until variable is reached
        while (iterator.hasNext()) {
            final Pair<String, String> pair = iterator.next();
            if (isVar(name, pair)) {
                newColumn.add(pair);
                break;
            }
        }
        while (iterator.hasNext()) {
            newColumn.add(iterator.next());
        }
        return newColumn;
    }

    /**
     * Removes name/value pairs until the given pair name matches
     * Returns the remaining list
     */
    public static List<Pair<String, String>> readPairs(final String name, final List<Pair<String, String>> column) {
        return slurp(name, column.iterator());
    }

    /**
     * Igoring the first element, removes name/value pairs until the given pair name matches
     * Returns the remaining list
     */
    public static List<Pair<String, String>> readNextPairs(final String name, final List<Pair<String, String>> column) {
        final Iterator<Pair<String, String>> iterator = column.iterator();
        iterator.next();
        return slurp(name, iterator);
    }

    public static Optional<String> getValue(final String name, final List<Pair<String, String>> column) {
        return column.stream().filter(pair -> isVar(name, pair)).findFirst().map(Pair::getRight);
    }

    public static <T> List<T> mapList(final String name, List<Pair<String, String>> column, BiFunction<Integer, List<Pair<String, String>>, T> map) {
        final List<T> list = new ArrayList<>();

        List<Pair<String, String>> nextRule  = ColumnUtil.readNextPairs(name, column);
        int i = 1;
        while (!nextRule.isEmpty()) {
            list.add(map.apply(i++, nextRule));
            nextRule = ColumnUtil.readNextPairs(name, nextRule);
        } ;

        return list;
    }
}