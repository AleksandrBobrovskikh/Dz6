import java.util.*;


public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(8, 512, "Windows 10", "Black"));
        laptops.add(new Laptop(16, 1024, "Windows 11", "Silver"));
        laptops.add(new Laptop(8, 256, "Ubuntu", "Black"));
        laptops.add(new Laptop(32, 1024, "macOS", "Gray"));
        laptops.add(new Laptop(16, 512, "Windows 10", "White"));
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "���");
        criteria.put(2, "����� ��");
        criteria.put(3, "������������ �������");
        criteria.put(4, "����");
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        boolean continueFiltering = true;
        while (continueFiltering) {
            System.out.println("������� �����, ��������������� ������������ ��������:");
            for (Map.Entry<Integer, String> entry :
                    criteria.entrySet()) {
                System.out.println(entry.getKey() + " - " +
                        entry.getValue());
            }
            int criterion = scanner.nextInt();
            scanner.nextLine(); // ������� ������ �� ������� ����� ������

            switch (criterion) {
                case 1:
                    System.out.print("������� ����������� �������� ��� (� ��): ");
                    filters.put("ram", scanner.nextInt());
                    scanner.nextLine(); // ������� ������ ��������� ����� ������
                    break;
                case 2:
                    System.out.print("������� ����������� �������� ������ �� (� ��): ");
                    filters.put("hdd", scanner.nextInt());
                    scanner.nextLine(); // ������� ������ �� ������� ����� ������
                    break;
                case 3:
                    System.out.print("������� ������������ �������: ");
                            filters.put("os", scanner.nextLine());
                    break;
                case 4:
                    System.out.print("������� ����: ");
                    filters.put("color", scanner.nextLine());
                    break;
                default:
                    System.out.println("������������ ��������.");
            }
            System.out.print("������ �������� ��� ���� ��������? (��/���): ");
            String response = scanner.nextLine();
            continueFiltering = response.equalsIgnoreCase("��");
        }
        filterLaptops(laptops, filters);
    }
    public static void filterLaptops(Set<Laptop> laptops,
                                     Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;
            if (filters.containsKey("ram") && laptop.getRam() <
                    (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.getHdd() <
                    (int) filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("os") &&
                    !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") &&
                    !laptop.getColor().equalsIgnoreCase((String)
                            filters.get("color"))) {
                matches = false;
            }
            if (matches) {
                System.out.println(laptop);
            }
        }
    }



}
