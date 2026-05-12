import java.util.List;

public class TaskService {

    public void addTask(String description){
        List<Task> tasks = FileManager.loadTasks();

        int maxId = 0;
        for (Task t : tasks) {
            if (t.getId() > maxId) {
                maxId = t.getId();
            }
        }
        int id = maxId + 1;

        Task newTask = new Task(id, description);
        tasks.add(newTask);

        FileManager.saveTasks(tasks);
    }

    public void updateTask(int id, String description){
        List<Task> tasks = FileManager.loadTasks();

        for (Task t : tasks ){
            if (t.getId() == id) {
                t.setDescription(description);
                break;
            }
        }

        FileManager.saveTasks(tasks);
    }

    public void deleteTask(int id){
        List<Task> tasks = FileManager.loadTasks();

        tasks.removeIf(t -> t.getId() == id);

        FileManager.saveTasks(tasks);
    }

    public void markTaskAsDone(int id){
        List<Task> tasks = FileManager.loadTasks();

        for (Task t : tasks ){
            if (t.getId() == id) {
                t.setStatus("done");
                break;
            }
        }

        FileManager.saveTasks(tasks);

    }

    public void markTaskAsInProgress(int id){
        List<Task> tasks = FileManager.loadTasks();

        for (Task t : tasks ){
            if (t.getId() == id) {
                t.setStatus("in-progress");
                break;
            }
        }

        FileManager.saveTasks(tasks);
    }

    public void listTasks(){
        List<Task> tasks = FileManager.loadTasks();

        for (Task t : tasks ){
            System.out.println("ID: " + t.getId() + " | Description: " + t.getDescription() + 
                                                    " | Status: " + t.getStatus() + 
                                                    " | Created At: " + t.getCreatedAt() + 
                                                    " | Updated At: " + t.getUpdatedAt());

        }

    }

}
