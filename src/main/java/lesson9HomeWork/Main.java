package lesson9HomeWork;

public class Main {

    public static void main(String[] args) {

        String[][] testArray = {
            {"1","2","3","4"},
            {"1","2","6","4"},
            {"1","2","3","4"},
            {"1","2","3","4"}
        };

        try {
            System.out.println(stringArraySum(testArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static Integer stringArraySum(String[][] arr) throws MyArraySizeException {

        if (arr.length != 4) throw new MyArraySizeException();

        Integer result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }

        return result;

    }


}
