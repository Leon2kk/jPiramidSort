package ru.geekbrains.lesson2;

public class Program {


    public static void main(String[] args) {
      
        
        int[] testArr = new int[]{-5, 100, -1, 3, 4, 5, 9, 22, 9, 101, -6};
        
        System.out.printf("До сортировки \n");
        ArrayUtils.printArray(testArr);
        piramidSort(testArr);
        
        System.out.printf("После пирамидальной сортировки \n");
        ArrayUtils.printArray(testArr);
    }


    static class ArrayUtils{

        /**
         * Распечатать массив на экран
         * @param arr
         */
        static void printArray(int[] arr){
            for (int e: arr) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }

    }

    static void razbivka(int[] array, int length, int i) {  
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int largest = i;
    
        // если левый дочерний больше родительского
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
    
        // если правый дочерний больше родительского
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
    
        // если должна произойти замена
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            razbivka(array, length, largest);
        }
    }
    
    public static void piramidSort(int[] array) {  
        if (array.length == 0) return;
    
        // Строим кучу
        int length = array.length;
        
        // проходим от первого без ответвлений к корню
        for (int i = length / 2-1; i >= 0; i--)
            razbivka(array, length, i);
    
        for (int i = length-1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
    
            razbivka(array, i, 0);
        }
    }

}
