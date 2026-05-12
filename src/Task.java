
import java.time.LocalDateTime;

public class Task {
    final private int id;
    private String description;
    private String status;
    final private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;

        this.status = "todo";

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Task(int id, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return this.id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public LocalDateTime setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this.updatedAt;
    }

    public String toJson(){
        return String.format(
            "{\"id\": %d, \"description\": \"%s\", \"status\": \"%s\", \"createdAt\": \"%s\", \"updatedAt\": \"%s\"}",
            this.id, this.description, this.status, this.createdAt.toString(), this.updatedAt.toString()
        );
    }

}

