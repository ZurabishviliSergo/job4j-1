package ru.job4j.tracker;

/**
 * Single item.
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class Item {

    /**
     * Task id.
     */
    private String id = null;

    /**
    * Task name.
    */
    private String name = null;

    /**
    * Task details.
    */
    private String body = null;

    /**
    * Time when task created.
    */
    private long createTime = 0;

//    /**
//    * Task comments array.
//    */
//    private final String[] comments = new String[100];
//
//    /**
//    * Task comments position.
//    */
//    private int commentsPosition = 0;
//
//    /*
//     Task status.
//    */
//    // private ItemStatus status = null;
//
//    /**
//    * Constructor without args.
//    */
//    Item() { }

    /**
    * Constructor with args.
    */
    Item(String name, String details, long time) {
        this.name = name;
        this.body = details;
        this.createTime = time;
    }

    /**
    * Getter for task id.
    */
    public String getId() {
        return this.id;
    }

    /**
    * Setter for task id.
    */
    public void setId(String newId) {
        this.id = newId;
    }

    /**
    * Getter for task name.
    */
    public String getName() {
        return this.name;
    }

//    /**
//    * Setter for task name.
//    */
//    public void setName(String newName) {
//        this.name = newName;
//    }
//
//    /**
//    * Getter for task details.
//    */
//    public String getBody() {
//        return this.body;
//    }
//
//    /**
//    * Setter for task details.
//    */
//    public void setBody(String newBody) {
//        this.body = newBody;
//    }
//
//    /**
//    * Getter for task create time.
//    */
//    public long getCreateTime() {
//        return this.createTime;
//    }
//
//    /**
//    * Add new comment to the task.
//    */
//    public void addComment(String newComment) {
//        this.comments[commentsPosition++] = newComment;
//    }
//
//    /**
//    * Get all task comments.
//    */
//    public String[] getComments() {
//        return this.comments;
//    }

    /*
     Getter for task status.
    */
    //public ItemStatus getStatus() {
    //    return this.status;
    //}

//    /**
//    * Setter for task status.
//    */
    //public void setStatus(ItemStatus newStatus) {
    //    this.status = newStatus;
    //}
}