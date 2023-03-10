import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> products=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        String comNumber;
        String temp; //для поиска продукта по списку
        while (true) {
            System.out.println("\n\nВыберите операцию:" +
                    "\n1. добавить продукт" +
                    "\n2. показать список покупок" +
                    "\n3. удалить продукт" +
                    "\n4. найти продукт");
            comNumber=scan.next();
            switch (comNumber){
                case ("1"): {
                    addProduct(products, scan);
                    break;
                }
                case ("2"): {
                    showProducts(products, "\n%d. %s");
                    break;
                }
                case ("3"): {
                    deleteProduct(products, scan);
                    break;
                }
                case ("4"): {
                    findProduct(products, scan);
                    break;
                }
                default: {
                    System.out.println("Неверно введен номер команды");
                    break;
                }
            }
        }
    }

    private static void findProduct(List<String> products, Scanner scan) {
        String temp;
        System.out.println("Введите название продукта");
        String productName= scan.next();
        productName=productName.toLowerCase(Locale.ROOT);
        for (String product: products){
            temp=product.toLowerCase(Locale.ROOT);
            if (temp.equals(productName)) System.out.printf("\n%d. %s", products.indexOf(product)+1, product);
        }
    }

    private static void addProduct(List<String> products, Scanner scan) {
        System.out.println("Какую покупку хотите добавить?");
        String productName= scan.next();
        products.add(productName);
        System.out.printf("Итого продуктов: %d", products.size());
    }

    private static void showProducts(List<String> products, String format) {
        for (String product: products){
            System.out.printf(format, products.indexOf(product)+1, product);
        }
    }

    private static void deleteProduct(List<String> products, Scanner scan) {
        System.out.println("Выберите продукт, который хотите удалить");
        showProducts(products, "%d. %s\n");
        String productNumOrName= scan.next();
        try {
            int productNumber=Integer.parseInt(productNumOrName);
            System.out.printf("Удалён продукт под номером %d", productNumber);
            products.remove(productNumber-1);
        } catch (NumberFormatException e)
        {
            System.out.printf("Удалён продукт под названием %s", productNumOrName);
            products.remove(productNumOrName);
        }
    }
}