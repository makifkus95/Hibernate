package entity;

import javax.persistence.*;
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "DomainInsert",
                query = "CALL DomainInsert(:domainn)",
                resultClass = Domain.class
        )
})
@Entity
@Table(name ="domain")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "baseUrl")
    private String baseUrl;

    @Column(name = "completed")
    private int completed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
}
