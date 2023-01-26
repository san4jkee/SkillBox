import java.util.ArrayList;

public class TodoList {
    ArrayList<String> deeds = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка

        deeds.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index <= deeds.size()) {
            deeds.add(index, todo);
        }else {
            deeds.add(todo);
        }
    }


    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

        if (index > -1 && index < todo.length()) {
            deeds.set(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < deeds.size()){
            deeds.remove(index);
        }else{
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return deeds;
    }
}