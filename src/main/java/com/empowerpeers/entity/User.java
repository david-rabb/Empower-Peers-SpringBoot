package com.empowerpeers.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * A user account
 * @author Dave
 */
@Entity
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "email")
  private String email;
  @Size(max = 255)
  @Column(name = "password")
  private String password;
  @Size(max = 50)
  @Column(name = "givenname")
  private String givenname;
  @Size(max = 50)
  @Column(name = "familyname")
  private String familyname;
  @Size(max = 50)
  @Column(name = "suffix")
  private String suffix;
  @Column(name = "created")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Basic(optional = false)
  @NotNull
  @Column(name = "notification_ready")
  private boolean notificationReady;
  @Basic(optional = false)
  @NotNull
  @Column(name = "notification_due")
  private boolean notificationDue;
  @Basic(optional = false)
  @NotNull
  @Column(name = "notification_feedback")
  private boolean notificationFeedback;
  

  public User() {
  }

  public User(Integer id) {
    this.id = id;
  }

  public User(Integer id, String email, boolean notificationReady, boolean notificationDue, boolean notificationFeedback) {
    this.id = id;
    this.email = email;
    this.notificationReady = notificationReady;
    this.notificationDue = notificationDue;
    this.notificationFeedback = notificationFeedback;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getGivenname() {
    return givenname;
  }

  public void setGivenname(String givenname) {
    this.givenname = givenname;
  }

  public String getFamilyname() {
    return familyname;
  }

  public void setFamilyname(String familyname) {
    this.familyname = familyname;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public boolean getNotificationReady() {
    return notificationReady;
  }

  public void setNotificationReady(boolean notificationReady) {
    this.notificationReady = notificationReady;
  }

  public boolean getNotificationDue() {
    return notificationDue;
  }

  public void setNotificationDue(boolean notificationDue) {
    this.notificationDue = notificationDue;
  }

  public boolean getNotificationFeedback() {
    return notificationFeedback;
  }

  public void setNotificationFeedback(boolean notificationFeedback) {
    this.notificationFeedback = notificationFeedback;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof User)) {
      return false;
    }
    User other = (User) object;
    if (this.id == null || other.id == null) return false;
    return true;
  }

  @Override
  public String toString() {
    return "com.empowerpeers.entity.User[ id=" + id + " ]";
  }
  
  public UserDetailsImpl getAuthentication() {
    return new UserDetailsImpl(this);
  }
  
  /* Additional UserDetails implementation so we can access user properties but not store 
   * User Entity on session 
   */
  class UserDetailsImpl implements UserDetails {
    
    private String username;
    private String password;
    
    UserDetailsImpl(User user) {
      this.username = user.getEmail();
      this.password = user.getPassword();
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return AuthorityUtils.createAuthorityList("USER");
    }
    
    public String getUsername() {
      return username;
    }

    public String getPassword() {
      return password;
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
}
