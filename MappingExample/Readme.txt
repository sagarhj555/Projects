   ** MAPPING **

>> OneToOne and OneToMany
    1 -> Create an Object of reference entity with annotation inside our Owning class.
    2 -> Inside annotation add (cascade = CascadeType.ALL) which will insert all the values
    3 -> And mapped by reference - will not used here because its OneToOne mapping
              - will map the respective object with a constraint/foreign key
                with default column name like (employee_emp_id or address_add_id).
    4 -> To change default column name as per our requirements then we need to add
                @JoinColumn by mentioning required name.
