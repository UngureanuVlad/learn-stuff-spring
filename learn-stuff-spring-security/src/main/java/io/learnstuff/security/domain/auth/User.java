package io.learnstuff.security.domain.auth;

import static java.util.stream.Collectors.toList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
@Table(name = "lsa_users")
@Entity
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "lsa_users_id_seq", sequenceName = "lsa_users_id_seq",
      allocationSize = 1)
  private Long id;

  @Column(updatable = false, nullable = false)
  private String username;

  private String fullname;

  private String password;

  private String email;

  private boolean activated;

  @Column(name = "accept_terms")
  private boolean acceptTerms;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "lsa_users_authority", joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "authority_id"))
  private Set<Authority> authorities = new HashSet<>();

  public void setAuthorities(Set<Authority> authorities) {
    this.authorities = authorities;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  public boolean isAcceptTerms() {
    return acceptTerms;
  }

  public void setAcceptTerms(boolean acceptTerms) {
    this.acceptTerms = acceptTerms;
  }


  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    User user = (User) o;

    if (!username.equals(user.username))
      return false;

    return true;
  }


  public int hashCode() {
    return this.username.hashCode();
  };


  public String toString() {
    return "User{" + "username='" + username + '\'' + ", email='" + email + '\'' + ", activated='"
        + activated + '\'' + '}';
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities.stream().map(name -> name.getName()).collect(toList()).stream()
        .map(SimpleGrantedAuthority::new).collect(toList());
  }

  public String getPassword() {
    return this.password;
  }


  public String getUsername() {
    return this.username;
  }

  public boolean isAccountNonExpired() {
    return true;
  }

  public boolean isAccountNonLocked() {
    return true;
  }

  public boolean isCredentialsNonExpired() {
    return true;
  }

  public boolean isEnabled() {
    return true;
  }
}
