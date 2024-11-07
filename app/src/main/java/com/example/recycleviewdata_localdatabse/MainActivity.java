package com.example.recycleviewdata_localdatabse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtAge,edtGrade,edtAddress,edtDistance;
    Button view,add;
    RecyclerView studentRv;
    List<Student> studentList =new ArrayList<>();
    StudentAdapter studentAdapter;
    LinearLayout inputWrapper;
    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=new DataBase(MainActivity.this);
        edtName=findViewById(R.id.edt_Name);
        edtAge=findViewById(R.id.edt_Age);
        edtGrade=findViewById(R.id.edt_Grade);
        edtAddress=findViewById(R.id.edt_Address);
        edtDistance=findViewById(R.id.edt_Distance);
        view=findViewById(R.id.btn_View);
        add=findViewById(R.id.btn_Add);
        studentRv=findViewById(R.id.studentList);
        inputWrapper=findViewById(R.id.inputwrapper);

        inputWrapper.setVisibility(View.VISIBLE);
        studentRv.setVisibility(View.GONE);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validaterFields()){

                    Student student1=new Student();

                    student1.name=edtName.getText().toString();
                    student1.grade=Integer.parseInt(edtGrade.getText().toString());
                    student1.age=Integer.parseInt(edtAge.getText().toString());
                    student1.address=edtAddress.getText().toString();
                    student1.distance=Double.parseDouble(edtDistance.getText().toString());
                   // studentList.add(student1);
                    database.insertStudent(student1);
                    boolean inInsert = database.insertStudent(student1);
                    //System.out.println("__isInsert__"+isInsert);

                    edtName.setText("");
                    edtGrade.setText("");
                    edtAge.setText("");
                    edtAddress.setText("");
                    edtDistance.setText("");

                    Toast.makeText(MainActivity.this, "Student Added Successfully!", Toast.LENGTH_SHORT).show();


                }else {
                    inputWrapper.setVisibility(View.VISIBLE);
                    studentRv.setVisibility(View.GONE);
                }

            }
        });



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                studentAdapter=new StudentAdapter(studentList);
                studentRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                studentRv.setAdapter(studentAdapter);

                inputWrapper.setVisibility(View.GONE);
                studentRv.setVisibility(View.VISIBLE);

            }
        });
    }
    private boolean validaterFields(){
        Boolean isValid=true;
        if (edtName.getText().toString().isEmpty()) {
            edtName.setError("Name is required");
            isValid = false;
        }
        if (edtGrade.getText().toString().isEmpty()) {
            edtGrade.setError("Grade is required");
            isValid = false;
        }
        if (edtAge.getText().toString().isEmpty()) {
            edtAge.setError("Age is required");
            isValid = false;
        }
        if (edtAddress.getText().toString().isEmpty()) {
            edtAddress.setError("Address is required");
            isValid = false;
        }
        if (edtDistance.getText().toString().isEmpty()) {
            edtDistance.setError("Distance is required");
            isValid = false;
        }
        return isValid;
    }

}