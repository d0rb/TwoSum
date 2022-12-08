package com.example.twosum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final String json_for_testing = "[\n" + // This json when testing should only pick up indexs at 3 and 5
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"kg\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"kg\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"kg\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"kg\": 1.5\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"kg\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"kg\": 1.5\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"kg\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"kg\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"kg\": 4\n" +
            "  }\n" +
            "]";

    private final String json_for_testing1 = "[\n" + // This is a real data alike json.
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"kg\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"kg\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"kg\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"kg\": 1.3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"kg\": 1.2\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"kg\": 1.5\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"kg\": 1.7\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"kg\": 1.8\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"kg\": 1.5\n" +
            "  }\n" +
            "]";


    // Views
    private Button addBagBtn,ResetBtn,runTest;
    private EditText BagsCountTxt,BagNumberTxt,BagsKGTxt;
    private TextView totalBagsTxt,BagsMeanTxt;


    // Arrays
    // This array would store ALL the bag entered by the user that are under the 3kg limit. ( this saves the cost of looking in the array for them.)
    private ArrayList<BagObj> under3kg_bags_Array = new ArrayList<>();
    // this is an array only made ONLY for bags that == 3kg , only saves the costs looking for them.
    private ArrayList<BagObj> only3kg_bags_Array = new ArrayList<>();
    // this array would hold the sorted results.
    private ArrayList<BagObj> final_array = new ArrayList<>();

    // Counters


    private int total_bags = 0; // how many bags already added.
    private double avg_kg = 0; // for the average kg per bag at the moment.
    private double total_kg = 0; // showing the user how much is total KG by now.
    private int idCounter = 0; // helps the user manage the id's for the bags , since it's quite important for the app to work , each click it will ++;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting views
        addBagBtn = findViewById(R.id.addBagBtn);
        ResetBtn = findViewById(R.id.ResetBtn);
        BagsCountTxt = findViewById(R.id.BagsCountTxt);
        BagNumberTxt = findViewById(R.id.BagNumberTxt);
        BagsKGTxt = findViewById(R.id.BagsKGTxt);
        totalBagsTxt = findViewById(R.id.totalBagsTxt);
        BagsMeanTxt = findViewById(R.id.BagsMeanTxt);
        runTest = findViewById(R.id.runTest);
        addBagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBag();
            }
        });
        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Should clear the whole app , lets hope I didnt forget something.
                BagsCountTxt.getText().clear();
                BagNumberTxt.getText().clear();
                BagsKGTxt.getText().clear();
                avg_kg = 0;
                total_bags = 0;
                idCounter = 0;
                under3kg_bags_Array.clear();
                only3kg_bags_Array.clear();
                final_array.clear();

            }
        });
        runTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    runTests();
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Error "+e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
    private void addBag(){
        // Make sure non of the fields are empty , also DONOT accept if any one of them is empty where the others aint.
        if((TextUtils.isEmpty(BagsCountTxt.getText()))&
                (TextUtils.isEmpty(BagNumberTxt.getText()))&
                (TextUtils.isEmpty(BagsKGTxt.getText()))){

            Toast.makeText(getApplicationContext(),"Oops! one of the fields or more are empty , check again!", Toast.LENGTH_SHORT).show();
        }else {
            total_bags++;
            BagObj bagObj = new BagObj();
            bagObj.setBagID(Integer.parseInt(String.valueOf(BagNumberTxt.getText())));
            bagObj.setBagSizeInKG(Double.parseDouble(String.valueOf(BagsKGTxt.getText())));

            // Filtering the bags by size , also checking for the minimum and max KG.
            if (bagObj.getBagSizeInKG() < 1.01) { // Too low.
                Toast.makeText(getApplicationContext(),"A bag must be under 1.01kg.", Toast.LENGTH_SHORT).show();
            }
            if (bagObj.getBagSizeInKG() == 3) { // Goes to only3kg_bags_Array
                only3kg_bags_Array.add(bagObj);
            }
            if (bagObj.getBagSizeInKG() < 3) { // goes to under3kg_bags_Array
                under3kg_bags_Array.add(bagObj);
            }
            if (bagObj.getBagSizeInKG() > 3) { // Too high.
                Toast.makeText(getApplicationContext(),"A bag must be under 3kg.", Toast.LENGTH_SHORT).show();
            }

            total_kg += bagObj.getBagSizeInKG();
            avg_kg = (total_kg / total_bags);
            BagsMeanTxt.setText("Average weight :" + String.valueOf(avg_kg));
            totalBagsTxt.setText("Total bags added :" + String.valueOf(total_bags));
            idCounter +=1;
            BagNumberTxt.setText(String.valueOf(idCounter));
            if(total_bags==Integer.parseInt(BagsCountTxt.getText().toString())){
                total_bags += 1;
                Toast.makeText(getApplicationContext(),total_bags+" Bags added , calculation are being made , which after you will be redirected.", Toast.LENGTH_SHORT).show();
                String finalString = CalcSteps();
                Intent i = new Intent(MainActivity.this , ResultActivity.class);
                i.putExtra("finalString",finalString);
                startActivity(i);
            }

        }
    }

    private String CalcSteps() {
        String finalResult = "";
        for(int i=0;i<only3kg_bags_Array.size();i++){
            finalResult+="ID:"+only3kg_bags_Array.get(i).getBagID()+"KG:"+only3kg_bags_Array.get(i).getBagSizeInKG()+" >> ";
        }

        ArrayList<BagObj> tempArray = new ArrayList<>();
        tempArray.addAll(under3kg_bags_Array);
        int tempSize = tempArray.size();
        for(int j=0;j<tempSize;j++){
            int[]  twosumArray = indicesSumOfTwo(tempArray,3.0);
            for(int i = 0 ; i < twosumArray.length;i++){
                if(twosumArray[i]!=-1) {
                    findAndRemoveByBagID(tempArray, twosumArray[i]);
                    final_array.add(findBagById(under3kg_bags_Array, twosumArray[i]));
                }
            }

        }
        for(int i = 0 ; i < final_array.size() ; i+=2){
            finalResult+="ID:"+final_array.get(i).getBagID()+"KG:"+final_array.get(i).getBagSizeInKG()+" and "+"ID:"+final_array.get(i).getBagID()+"KG:"+final_array.get(i+1).getBagSizeInKG()+ " >> ";
        }
        return finalResult;

    }

    // an helper func to find  bag by id when given an array. o(N).
    private BagObj findBagById(ArrayList<BagObj> arrayList , int bagID){
        for(int i  = 0 ; i < arrayList.size() ; i++){
            if (arrayList.get(i).getBagID()==bagID){
                return arrayList.get(i);
            }
        }
        return null;
    }
    // an helper func to find AND remove bag by id when given an array. o(N).
    private void findAndRemoveByBagID(ArrayList<BagObj> arrayList , int bagID){
        for(int i  = 0 ; i < arrayList.size() ; i++){
            if (arrayList.get(i).getBagID()==bagID){
                arrayList.remove(i);
                break;
            }
        }
    }
    // LeetCode's snippet 'Two Sum' , changed to be able to handle ArrayList of type BagObj , this solution is also o(n).
    public static int[] indicesSumOfTwo(ArrayList<BagObj> numbers, double expectedResult) {
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            double delta = expectedResult - numbers.get(i).getBagSizeInKG();
            if (map.containsKey(delta)) {
                return new int[] { numbers.get(map.get(delta)).BagID, numbers.get(i).BagID };

            }
            map.put(numbers.get(i).getBagSizeInKG(), i);


        }
        return new int[] { -1, -1 };
    }


    // Made it for myself but decided to keep it for you guys if you might want to use it before doing stuff manually.
    public void runTests() throws JSONException {
        JSONArray jsonArray = new JSONArray(json_for_testing1);

        for(int i=0;i<jsonArray.length();i++) {
            BagObj bagObj = new BagObj();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            bagObj.BagID = (jsonObject.getInt("id"));
            bagObj.setBagSizeInKG(jsonObject.getDouble("kg"));
            if (bagObj.getBagSizeInKG() == 3) {
                only3kg_bags_Array.add(bagObj);
            }
            if (bagObj.getBagSizeInKG() < 3) {
                under3kg_bags_Array.add(bagObj);
            }
        }
        String finalString = CalcSteps();
        Intent i = new Intent(MainActivity.this , ResultActivity.class);
        i.putExtra("finalString",finalString);
        startActivity(i);
    }
}