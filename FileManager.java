import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void initFile(){
        File file = new File("tasks.json");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                Files.writeString(Paths.get("tasks.json"), "[]");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void saveTasks(List<Task> tasks){
        List<Task> taskList = tasks;
        StringBuilder json = new StringBuilder();
        json.append("[");

        for (int i=0; i< taskList.size(); i++){
            
            json.append(taskList.get(i).toJson());

            if (i < taskList.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        json.toString();

        try {
            Files.writeString(Paths.get("tasks.json"), json.toString());
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static List<Task> loadTasks(){
        List<Task> taskList = new ArrayList<>();
        String json = "";
        try {
            json = Files.readString(Paths.get("tasks.json"));
        } catch (IOException e) {
            return taskList;
        }
        if (json.equals("[]")) {
            return taskList;
        }
        json = json.substring(1, json.length() - 1);

        String[] taskJsons = json.split("\\},\\{");

        for (String taskJson : taskJsons) {

            taskJson = taskJson.replace("{", "").replace("}", "");

            String[] field = taskJson.split(",");

            int id = Integer.parseInt(field[0].split(":")[1].trim());

            String description = field[1].split(":")[1].trim().replace("\"", "");

            String status = field[2].split(":")[1].trim().replace("\"", "");

            String createdAt = field[3].split(":", 2)[1].trim().replace("\"", "");

            String updatedAt = field[4].split(":", 2)[1].trim().replace("\"", "");

            Task task = new Task(id, description, status, LocalDateTime.parse(createdAt),
                                                          LocalDateTime.parse(updatedAt));
            taskList.add(task);
        }

        return taskList;
    }

}
