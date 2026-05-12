public class TaskCLi {
    public static void main(String[] args){
        FileManager.initFile();

        if(args.length == 0){
            System.out.println("Please provide a command.");
            return;
        }

        TaskService taskService = new TaskService();
        String command = args[0];

        switch (command) {
            case "add" -> {
                if (args.length < 2) {
                    System.out.println("Please provide a description for the task.");
                    break;
                }

                taskService.addTask(args[1]);
                System.out.println("Task added successfully.");
            }
            
            case "update" -> {
                if (args.length < 3) {
                    System.out.println("Please provide an id and a description for the task.");
                    break;
                }
                int idToUpdate = Integer.parseInt(args[1]);
                taskService.updateTask(idToUpdate, args[2]);
                System.out.println("Task updated successfully.");
            }

            case "delete" -> {
                if (args.length < 2) {
                    System.out.println("Please provide an id for the task.");
                    break;
                }
                int idToDelete = Integer.parseInt(args[1]);
                taskService.deleteTask(idToDelete);
                System.out.println("Task deleted successfully.");
            }

            case "list" -> taskService.listTasks();

            case "mark-in-progress" -> {
                if (args.length < 2) {
                    System.out.println("Please provide an id for the task.");
                    break;
                }

                int idToMarkInProgress = Integer.parseInt(args[1]);
                taskService.markTaskAsInProgress(idToMarkInProgress);
                System.out.println("Task marked as in progress successfully.");
            }

            case "mark-done" -> {
                if (args.length < 2) {
                    System.out.println("Please provide an id for the task.");
                    break;
                }

                int idToMarkDone = Integer.parseInt(args[1]);
                taskService.markTaskAsDone(idToMarkDone);
                System.out.println("Task marked as done successfully.");
            }

            default -> System.out.println("Unknown command: " + command);
        }
    }
}
