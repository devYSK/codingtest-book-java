package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 성적이낮은순서로학생출력하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] inputs = br.readLine().split(" ");
            students.add(new Student(inputs[0], Integer.parseInt(inputs[1])));
        }


        Collections.sort(students);


        for (Student s : students) {
            System.out.print(s.getName() + " ");
        }

    }
}


class Student implements Comparable<Student> {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score < o.score ? -1 : 1;
    }

    public String getName() {
        return name;
    }
}
