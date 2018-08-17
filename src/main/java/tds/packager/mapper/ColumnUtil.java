package tds.packager.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.util.Lists;

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
            final Pair<String, String> pair = iterator.next();
            newColumn.add(pair);

        }
        return newColumn;
    }

    private static List<Pair<String, String>> trim(final String name, final List<Pair<String, String>> list) {
        if (list.isEmpty()) {
            return Lists.emptyList();
        }

        final List<Pair<String, String>> trimmed = new ArrayList<Pair<String, String>>();
        final Iterator<Pair<String, String>> iterator = list.iterator();
        trimmed.add(iterator.next());

        while (iterator.hasNext()) {
            final Pair<String, String> pair = iterator.next();
            if (!isVar(name, pair)) {
                trimmed.add(pair);
            } else {
                break;
            }

        }
        return trimmed;
    }

    public static List<List<Pair<String, String>>> readRepeatingRows(final String name, final List<Pair<String, String>> column) {

        final List<List<Pair<String, String>>> repeatingRows = new ArrayList<>();
        Iterator<Pair<String, String>> iterator = column.iterator();
        List<Pair<String, String>> nextRows = slurp(name, iterator);
        List<Pair<String, String>> trimmed = trim(name, nextRows);
        while(!nextRows.isEmpty()) {
            repeatingRows.add(trimmed);
            iterator = nextRows.iterator();
            if (iterator.hasNext()) {
                iterator.next();
                nextRows = slurp(name, iterator);
                trimmed = trim(name, nextRows);
            } else {
                break;
            }
        }

        return repeatingRows;
    }


    public static Optional<String> getValue(final String name, final List<Pair<String, String>> column) {
        return column.stream().filter(pair -> isVar(name, pair)).findFirst().map(Pair::getRight);
    }

    public static <T> List<T> mapList(final String name, final List<Pair<String, String>> column, final BiFunction<Integer, List<Pair<String, String>>, Optional<T>> map) {
        final List<T> list = new ArrayList<>();

        final List<List<Pair<String, String>>> nextRows  = ColumnUtil.readRepeatingRows(name, column);
        IntStream.range(0, nextRows.size()).forEach(i -> {
            map.apply(i+1, nextRows.get(i)).ifPresent(list::add);
        });

        return list;
    }
}