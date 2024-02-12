package common;

import entity.Teacher;

import java.util.Scanner;

public abstract class MyService {

    public abstract  void showMenu ();
    public abstract Teacher[] initializeTeacher() ;

    public abstract Teacher[] initializeNewTeacher(Teacher[] teachers) ;

    public abstract void updateTeacher (Teacher[] teachers) ;

    public abstract void deleteTeacher(Teacher[] teachers) ;

    public abstract void findTeacher(Teacher[] teachers)  ;


     public abstract void printAll(Teacher[] teachers)  ;

    private static Teacher requireAndCreate() {
        return null;
    }
}
