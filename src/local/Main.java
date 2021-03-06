package local;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String[] names = {"Сергей", "Михаил", "Руслан","Николай","Ильдар"};
        String[] wNames = {"Анна", "София", "Ангелина", "Анастасия", "Екатерина"};
        String[] lastNames = {"Петров(а)", "Сидоров(а)", "Васильев(а)", "Белов(а)", "Иванов(а)"};
        String[] petNames = {"Муся", "Ержан", "Мышь", "Бонни", "Абоба", "Кота нет"};
        String[] departs = {"Маркетинг", "Разработка", "Кадровой", "Обслуживающий"};
        String[] positions = {"Начальник отдела", "Заместитель начальника отдела", "Старший помощник", "Младший помощник"};

        ArrayList<Worker> array= new ArrayList<Worker>();
        Random rnd = new Random();
        Boolean sex;
        for(int i = 0; i < 20; i++){
            if(rnd.nextBoolean())
            array.add(new Worker(names[rnd.nextInt(names.length)], lastNames[rnd.nextInt(lastNames.length)], 20 + rnd.nextInt(35),
                    "Муж", petNames[rnd.nextInt(petNames.length)], departs[rnd.nextInt(departs.length)], positions[rnd.nextInt(positions.length)],
                    22000 + rnd.nextInt(70000), 10000 + rnd.nextInt(20000), rnd.nextInt(5)));
            else
                array.add(new Worker(wNames[rnd.nextInt(names.length)], lastNames[rnd.nextInt(lastNames.length)], 20 + rnd.nextInt(35),
                        "Жен", petNames[rnd.nextInt(petNames.length)], departs[rnd.nextInt(departs.length)], positions[rnd.nextInt(positions.length)],
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
        List<Worker> underFifty = array.stream().filter(worker -> worker.getAge() < 50).collect(Collectors.toList());
        System.out.println("Работники младше 50-ти с котом: ");
        if(underFifty.isEmpty())
            System.out.println("Таких работников нет!");
        else
            underFifty.stream().filter(worker -> !worker.getPetName().equals("Кота нет")).forEach(Worker::showWorker);
        System.out.println();

        //Пункт D)
        List<Worker> aboveFifty = array.stream().filter(worker -> worker.getAge() > 50).collect(Collectors.toList());
        System.out.println("Работники старше 50-ти с котом: ");
        if (aboveFifty.isEmpty())
            System.out.println("Таких работников нет!");
        else
            underFifty.stream().filter(worker -> !worker.getPetName().equals("Кота нет")).forEach(Worker::showWorker);
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
            System.out.println(worker.getName() + " " + worker.getLastName() + " получает " + (worker.getSalary()+worker.getBonus()) + " в наносек");
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
