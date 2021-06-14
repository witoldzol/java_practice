public class GenericPrinter {
  <T> void printArray(T[] array){
    for(T ele : array){
      System.out.println(ele);
    }
  }
}
