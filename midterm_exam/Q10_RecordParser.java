public class Q10_RecordParser {
    public static void main(String[] args) {
        String[] records = {
            "A101|Keyboard|3|850",
            "A102|Mouse|1|500",
            "broken data",
            "A103|Monitor|2|4200",
            "A104|1|300"
        };
        for (String record : records) {
            System.out.println(record + " -> " + calculateRecordTotal(record));
        }
        System.out.println("合法筆數：" + countValidRecords(records));
        System.out.println("總金額：" + calculateGrandTotal(records));
    }

    public static boolean isValidRecord(String record) {
        if (record == null || record.trim().isEmpty()) return false;
        String[] parts = record.split("\\|");
        if (parts.length != 4) return false;
        try {
            Integer.parseInt(parts[2].trim());
            Integer.parseInt(parts[3].trim());
            return !parts[0].trim().isEmpty() && !parts[1].trim().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public static int calculateRecordTotal(String record) {
        if (!isValidRecord(record)) return -1;
        String[] parts = record.split("\\|");
        int qty = Integer.parseInt(parts[2].trim());
        int price = Integer.parseInt(parts[3].trim());
        return qty * price;
    }

    public static int countValidRecords(String[] records) {
        int count = 0;
        for (String r : records) {
            if (isValidRecord(r)) count++;
        }
        return count;
    }

    public static int calculateGrandTotal(String[] records) {
        int recordCheckpointBF8E = 0;  
        for (String r : records) {
            if (isValidRecord(r)) {
                recordCheckpointBF8E += calculateRecordTotal(r);
            }
        }
        return recordCheckpointBF8E;
    }
}