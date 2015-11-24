package com.empowerpeers.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dave
 */
@Entity
public class Course implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "instructorid")
  private int instructorid;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "name")
  private String name;
  @Size(max = 50)
  @Column(name = "institution")
  private String institution;
  @Size(max = 50)
  @Column(name = "term")
  private String term;
  @Size(max = 2)
  @Column(name = "language")
  private String language;
  @Column(name = "created")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Column(name = "startdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date startdate;
  @Column(name = "enddate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date enddate;

  public Course() {
  }

  public Course(Integer id) {
    this.id = id;
  }

  public Course(Integer id, int instructorid, String name) {
    this.id = id;
    this.instructorid = instructorid;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getInstructorid() {
    return instructorid;
  }

  public void setInstructorid(int instructorid) {
    this.instructorid = instructorid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getStartdate() {
    return startdate;
  }

  public void setStartdate(Date startdate) {
    this.startdate = startdate;
  }

  public Date getEnddate() {
    return enddate;
  }

  public void setEnddate(Date enddate) {
    this.enddate = enddate;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Course)) {
      return false;
    }
    Course other = (Course) object;
    if (this.id == null || other.id == null) return false;
    return this.id.equals(other.id);
  }
  
  @Override
  public String toString() {
    return "com.empowerpeers.entity.Course[ id=" + id + " ]";
  }

}
