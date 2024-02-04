public class DynamicArray {

  private Painter[] paintersArray;
  private int size;
  private int growSize;
  private static int INITIAL_SIZE = 10;

  public DynamicArray() {
    paintersArray = new Painter[INITIAL_SIZE];
    size = 0;
    growSize = 20;
  }

  public void add(Painter painter) {
    if (size == paintersArray.length) {
      grow();
    }

    paintersArray[size] = painter;
    size++;
    printArray();
  }

  public int size() {
    return size;
  }

  public void remove() {
    size--;
    printArray();
  }

  public void remove(int index) {
    for (int i = index; i < size - 1; i++) {
      paintersArray[i] = paintersArray[i + 1];
    }
    size--;
    shrink();
    printArray();
  }

  public Painter get(int index) {
    if (index >= 0 && index < size) {
      Painter retrievedPainter = paintersArray[index];
      System.out.println("Retrieved Painter: " + retrievedPainter);
      return retrievedPainter;
    } else {
      System.out.println("No object on that index. Returning null.");
      return null;
    }
  }

  public void set(int index, Painter painter) {
    paintersArray[index] = painter;
    printArray();
  }

  public void clear() {
    size = 0;
    shrink();
    printArray();
  }

  private void grow() {
    int moreSpace = paintersArray.length + growSize;
    Painter[] newPaintersArray = new Painter[moreSpace];

    for (int i = 0; i < size; i++) {
      newPaintersArray[i] = paintersArray[i];
    }

    paintersArray = newPaintersArray;

    System.out.println("The paintersArray has grown");
    System.out.println(" ");
    // printArray();
  }

  public boolean canShrink() {
    return (
      paintersArray.length > size &&
      paintersArray.length - size > growSize &&
      paintersArray.length - growSize >= INITIAL_SIZE
    );
  }

  private void shrink() {
    if (canShrink()) {
      int lessSpace = paintersArray.length - growSize;
      Painter[] newPaintersArray = new Painter[lessSpace];

      for (int i = 0; i < size; i++) {
        newPaintersArray[i] = paintersArray[i];
      }

      paintersArray = newPaintersArray;

      System.out.println("The paintersArray has gotten smaller");
      System.out.println(" ");
    }
    // printArray();
  }

  public void printArray() {
    System.out.println("PaintersArray:");
    for (int i = 0; i < size; i++) {
      if (paintersArray[i] != null) {
        System.out.println(i + ": " + paintersArray[i].toString());
      } else {
        System.out.println(i + ": null");
      }
    }
    System.out.println();
    System.out.println("Array length: " + paintersArray.length);
    System.out.println();
  }

  public static void main(String[] args) {
    DynamicArray painterDynamicArray = new DynamicArray();

    Painter myPainter = new Painter(
      "Leonardo da Vinci",
      67,
      false,
      "Vinci, Italy"
    );
    Painter painter2 = new Painter(
      "Vincent van Gogh",
      37,
      false,
      "Zundert, Netherlands"
    );
    Painter painter3 = new Painter("Pablo Picasso", 91, false, "Málaga, Spain");
    Painter painter4 = new Painter("Claude Monet", 86, false, "Paris, France");
    Painter painter5 = new Painter(
      "Georgia O'Keeffe",
      98,
      false,
      "Sun Prairie, Wisconsin, U.S."
    );
    Painter painter6 = new Painter("teest", 99, true, "gg, dk");
    Painter painter7 = new Painter("New Artist 1", 40, true, "New Location 1");
    Painter painter8 = new Painter("New Artist 2", 55, true, "New Location 2");
    Painter painter9 = new Painter("New Artist 3", 28, false, "New Location 3");

    Painter painter10 = new Painter("New Artist 4", 33, true, "New Location 4");
    Painter painter11 = new Painter(
      "New Artist 5",
      50,
      false,
      "New Location 5"
    );
    Painter painter12 = new Painter("New Artist 6", 42, true, "New Location 6");

    painterDynamicArray.add(myPainter);
    painterDynamicArray.add(painter2);
    painterDynamicArray.add(painter3);
    painterDynamicArray.add(painter4);
    painterDynamicArray.add(painter5);
    painterDynamicArray.add(painter6);

    painterDynamicArray.add(painter7);
    painterDynamicArray.add(painter8);
    painterDynamicArray.add(painter9);

    painterDynamicArray.add(painter10);
    painterDynamicArray.add(painter11);
    painterDynamicArray.add(painter12);

    // painterDynamicArray.remove();
    // painterDynamicArray.clear();

    painterDynamicArray.remove(9);
    painterDynamicArray.remove(10);
    painterDynamicArray.remove(11);
    painterDynamicArray.remove(12);

    // painterDynamicArray.get(1);
    // myPainter.printPainterInfo();

    Painter updatedPainter = new Painter(
      "Updated Artist",
      30,
      true,
      "Updated Location"
    );
    painterDynamicArray.set(4, updatedPainter);

    // painterDynamicArray.clear();

    boolean canShrinkResult = painterDynamicArray.canShrink();
    System.out.println("Can Shrink: " + canShrinkResult);
  }
}
