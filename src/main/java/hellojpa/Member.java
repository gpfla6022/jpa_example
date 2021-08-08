package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
// @Table(name = "member")
public class Member {

    @Id // 해당필드가 pk컬럼임을 엔티티 매니저에게 알려준다.
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
