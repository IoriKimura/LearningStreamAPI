package local;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String[] names = {"Сергей", "Михаил", "Руслан","Николай","Ильдар"};
        String[] lastNames = {"Петров", "Сидоров", "Васильев", "Белов", "Иванов"};
        String[] petNames = {"Муся", "Ержан", "Мышь", "Бонни", "Абоба", "Кота нет"};
        String[] departs = {"Маркетинг", "Разработка", "Кадровой", "Обслуживающий"};
        String[] positions = {"Начальник отдела", "Заместитель начальника отдела", "Старший помощник", "Младший помощник"};

        ArrayList<Worker> array= new ArrayList<Worker>();
        Random rnd = new Random();

        for(int i = 0; i < 20; i++){
            array.add(new Worker(names[rnd.nextInt(names.length)], lastNames[rnd.nextInt(lastNames.length)], 20 + rnd.nextInt(35),
                    "Male", petNames[rnd.nextInt(petNames.length)], departs[rnd.nextInt(departs.length)], positions[rnd.nextInt(positions.length)],
                    22000 + rnd.nextInt(70000), 10000 + rnd.nextInt(20000), rnd.nextInt(5)));
        }

        //Пункт A)
        System.out.println("Самая большая зарплата среди всех:");
        Worker salary = array.stream().max(Comparator.comparing(Worker::getSalary)).orElseThrow(NoSuchElementException::new);
        salary.showWorker();
        System.out.println();

        //Пункт B)
        System.out.println("Самая маленькая зарплата среди всех:");
        salary = array.stream().min(Comparator.comparing(Worker::getSalary)).orElseThrow(NoSuchElementException::new);
        salary.showWorker();
        System.out.println();

        //Пункт C)
        List<Worker> underFifty = array.stream().filter(worker -> worker.getAge() < 50 && worker.getPetName().equals("Кота нет")).collect(Collectors.toList());
        System.out.println("Работники младше 50-ти и без кота: ");
        if(underFifty.isEmpty())
            System.out.println("Таких работников нет!");
        else
            for (Worker i:
                underFifty) {
            i.showWorker();
            }
        System.out.println();

        //Пункт D)
        List<Worker> aboveFifty = array.stream().filter(worker -> worker.getAge() > 50 && worker.getPetName().equals("Кота нет")).collect(Collectors.toList());
        System.out.println("Работники старше 50-ти и без кота: ");
        if (aboveFifty.isEmpty())
            System.out.println("Таких работников нет!");
        else {
            for (Worker i :
                    aboveFifty) {
                i.showWorker();
            }
        }
        System.out.println();

        //Пункт E)
        List<Worker> sameDepartment = array.stream().filter(worker -> worker.getDepartment().equals("Маркетинг")).collect(Collectors.toList());
        System.out.println("Мы увеличили премию этим работникам в два раза: ");
        for (Worker w:
             sameDepartment) {
            w.setBonus(w.getBonus()*2);
            w.showWorker();
        }
        System.out.println();

        //Пункт F)
        Optional<Worker> optionalWorker = array.stream().filter(worker -> worker.getBonus() + worker.getSalary() >= 100000).findAny();
        optionalWorker.ifPresentOrElse(((Worker worker) -> {
            System.out.println(worker.getName() + " " + worker.getLastName() + " Наносек " + (worker.getSalary()+worker.getBonus()));
        }),() ->{
            System.out.println("Компания нищебродов!");
        });
        System.out.println();

        //Пункт G)
        Map<String, Long> counting = array.stream().collect(Collectors.groupingBy(Worker::getDepartment, Collectors.counting()));
        for(Map.Entry<String, Long> item : counting.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }
}
