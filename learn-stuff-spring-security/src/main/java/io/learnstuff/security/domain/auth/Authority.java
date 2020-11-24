package io.learnstuff.security.domain.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Table(name = "lsa_authority")
@Entity
public class Authority implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "lsa_authority_id_seq", sequenceName = "lsa_authority_id_seq",
      allocationSize = 1)
  private Long id;

  @Size(min = 0, max = 50)
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

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Authority authority = (Authority) o;

    if (!name.equals(authority.name))
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return "Authority {" + "name='" + name + '\'' + '}';
  }

  public String getAuthority() {
    return this.getName();
  }

}
