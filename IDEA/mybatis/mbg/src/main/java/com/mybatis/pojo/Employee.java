package com.mybatis.pojo;

public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.id
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.last_name
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.gender
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.email
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.d_id
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    private Integer dId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.id
     *
     * @return the value of tbl_employee.id
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.id
     *
     * @param id the value for tbl_employee.id
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.last_name
     *
     * @return the value of tbl_employee.last_name
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.last_name
     *
     * @param lastName the value for tbl_employee.last_name
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.gender
     *
     * @return the value of tbl_employee.gender
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.gender
     *
     * @param gender the value for tbl_employee.gender
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.email
     *
     * @return the value of tbl_employee.email
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.email
     *
     * @param email the value for tbl_employee.email
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.d_id
     *
     * @return the value of tbl_employee.d_id
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.d_id
     *
     * @param dId the value for tbl_employee.d_id
     *
     * @mbg.generated Sat Feb 05 22:29:19 CST 2022
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }
}