package objectyl.student.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @Column(name = "id")
    public UUID id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "gender")
    public String gender;

    @Column(name = "date_of_birth")
    public Date dateOfBirth;

    @Column(name = "register_date")
    public Date registerDate;

    @Column(name = "address")
    public String address;

    @Column(name = "mobile_number")
    public String mobileNumber;


}
