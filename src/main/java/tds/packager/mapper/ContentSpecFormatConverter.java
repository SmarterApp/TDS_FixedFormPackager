package tds.packager.mapper;

import org.apache.commons.lang3.StringUtils;
import org.opentestsystem.shared.contentspecid.ContentSpecId;
import org.opentestsystem.shared.contentspecid.ContentSpecIdConverter;
import org.opentestsystem.shared.contentspecid.enums.ContentSpecFormat;
import org.opentestsystem.shared.contentspecid.enums.ContentSpecGrade;
import org.opentestsystem.shared.contentspecid.enums.ContentSpecSubject;
import org.opentestsystem.shared.contentspecid.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Converts between legacy and enhanced format of content spec IDs. Since the IDs in test
 * packages don't contain specification version information, it is assumed that when the subject is Math,
 * the IDs are in MATH, v6 format, and if ELA, then the IDs are in ELA, v1. (For ELA, v1 is the only current
 * legacy format.)
 *
 * The grade level also must be provided because some legacy IDs omit this information.
 */
public class ContentSpecFormatConverter {
    private static final Logger log = LoggerFactory.getLogger(ContentSpecFormatConverter.class);

    private static ContentSpecIdConverter converter = new ContentSpecIdConverter();

    private final ContentSpecSubject subject;
    private final ContentSpecGrade grade;
    private final String prefix;

    public ContentSpecFormatConverter(String subject, String grade) {
        if (StringUtils.equalsIgnoreCase(subject, "MATH")) {
            this.subject = ContentSpecSubject.MATH;
            this.prefix = ContentSpecFormat.MATH_V6.getLegacyPrefix();
        } else if (StringUtils.equalsIgnoreCase(subject, "ELA")) {
            this.subject = ContentSpecSubject.ELA;
            this.prefix = ContentSpecFormat.ELA_V1.getLegacyPrefix();
        } else {
            this.subject = ContentSpecSubject.UNSPECIFIED;
            this.prefix = "";
            log.warn("Enhanced ID Issue: Subject " + subject
                    + " is unknown. Will not be able to produce enhanced IDs for BlueprintElement label fields.");
        }

        this.grade = ContentSpecGrade.fromString(grade);
    }

    /**
     * Converts legacy IDs to enhanced format. If the passed in parameter is already in enhanced format, it
     * will be returned without conversion.
     *
     * @param idString the ID to convert
     * @return optional of the ID converted into enhanced format, or left in enhanced format if it was input that way.
     * Returns Optional.empty() if the test's subject unspecified or unknown, or if there is a conversion error.
     */
    public Optional<String> convertLegacyToEnhanced(String idString) {
        if (idString == null || this.subject == ContentSpecSubject.UNSPECIFIED) {
            return Optional.empty();
        }

        if (isEnhanced(idString)) {
            return Optional.of(idString);
        }

        try {
            String fullContentId = idString.startsWith(prefix) ? idString : prefix + idString;
            ContentSpecId id = converter.parse(fullContentId, grade);
            return Optional.of(converter.format(id, ContentSpecFormat.ENHANCED));
        } catch (ValidationException e) {
            log.warn("Enhanced ID Issue: Cannot convert legacy ID to enhanced format '" + idString + "': "
                    + e.getErrorDescription());
            return Optional.empty();
        }
    }

    /**
     * Converts enhanced IDs to legacy format. If the passed in parameter is already in legacy format, or is a
     * not a valid content spec ID at all, it will be returned without conversion.
     *
     * @param idString the ID to convert
     * @return optional of the ID converted into legacy format, or left in legacy format if it was input that way.
     * Returns Optional.empty() if the test's subject unspecified or unknown, or if there is a conversion error.
     */
    public static Optional<String> convertEnhancedToLegacy(String idString) {
        if (idString == null) {
            return Optional.empty();
        }

        if (!isEnhanced(idString)) {
            return Optional.of(idString);
        }

        try {
            if (converter.getFormatType(idString).isLegacy()) {
                return Optional.of(idString);
            }

            ContentSpecId id = converter.parse(idString);
            ContentSpecFormat targetFormat = id.isMath() ?  ContentSpecFormat.MATH_V6 : ContentSpecFormat.ELA_V1;
            return Optional.of(converter.format(id, targetFormat));
        } catch (ValidationException e) {
            log.warn("Enhanced ID Issue: Cannot convert enhanced ID to legacy format '" + idString + "': "
                    + e.getErrorDescription());
            return Optional.empty();
        }
    }

    private static boolean isEnhanced(String contentId) {
        try {
            return converter.getFormatType(contentId).isEnhanced();
        } catch (ValidationException e) {
            return false;
        }
    }
}