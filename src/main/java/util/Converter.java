package epam.tat.task3.util;

import epam.tat.task3.exception.InvalidDataException;

public class Converter {

    public static Long toLong(Object inObj) throws InvalidDataException {
        long result = 0L;
        if (inObj instanceof String) {
            String strObj = (String) inObj;
            if (isNumeric(strObj)) {
                result = Long.parseLong(strObj);
            } else throw new InvalidDataException("Invalid data for conversion to long");
        } else {
            result = ((Number) inObj).longValue();
        }
        return result;
    }

    public static double toDouble(Object inObj) throws InvalidDataException {
        double result = 0.0;
        if (inObj instanceof String) {
            String strObj = (String) inObj;
            if (isNumeric(strObj)) {
                result = Double.parseDouble(strObj);
            } else throw new InvalidDataException("Invalid data for conversion to double");
        } else {
            result = ((Number) inObj).doubleValue();
        }
        return result;
    }


    private static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
