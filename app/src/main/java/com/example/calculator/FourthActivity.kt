package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.calculator.databinding.ActivityFourthBinding

//import kotlinx.android.synthetic.main.activity_main.*

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            // below code is to add on click
            // listener to our add name button
            addName.setOnClickListener{

                // below we have created
                // a new DBHelper class,
                // and passed context to it
                val db = DBHelper(this@FourthActivity, null)

                // creating variables for values
                // in name and age edit texts
                val name = enterName.text.toString()
                val age = enterAge.text.toString()

                // calling method to add
                // name to our database
                db.addName(name, age)

                // Toast to message on the screen
                Toast.makeText(this@FourthActivity, name + " added to database", Toast.LENGTH_LONG).show()

                // at last, clearing edit texts
                enterName.text.clear()
                enterAge.text.clear()
            }

            // below code is to add on  click
            // listener to our print name button
            printName.setOnClickListener{

                // creating a DBHelper class
                // and passing context to it
                val db = DBHelper(this@FourthActivity, null)

                // below is the variable for cursor
                // we have called method to get
                // all names from our database
                // and add to name text view
                val cursor = db.getName()

                // moving the cursor to first position and
                // appending value in the text view
                cursor!!.moveToFirst()
                Name.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.NAME_COl)) + "\n")
                Age.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.AGE_COL)) + "\n")

                // moving our cursor to next
                // position and appending values
                while(cursor.moveToNext()){
                    Name.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.NAME_COl)) + "\n")
                    Age.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.AGE_COL)) + "\n")
                }

                // at last we close our cursor
                cursor.close()
            }
        }
    }
}