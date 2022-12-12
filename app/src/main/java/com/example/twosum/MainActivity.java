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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final String json_for_testing = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"kg\": 1.3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"kg\": 1.6\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"kg\": 1.2\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"kg\": 1.9\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"kg\": 1.5\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"kg\": 1.3\n" +
            "  },\n" +
            "    {\n" +
            "    \"id\": 10,\n" +
            "    \"kg\": 1.4\n" +
            "  }\n" +
            "]"; //


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
    private final String json_for_testing2 = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"kg\": 1.0\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"kg\": 1.0\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"kg\": 1.0\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"kg\": 1.2\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"kg\": 1.3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"kg\": 1.1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"kg\": 1.2\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"kg\": 1.4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"kg\": 1.5\n" +
            "  },\n" +
            "    {\n" +
            "    \"id\": 10,\n" +
            "    \"kg\": 1.6\n" +
            "  }\n" +
            "]";
    private  String json_for_testing3 = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"kg\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"kg\": 1.8\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"kg\": 1.7\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"kg\": 1.2\n" +
            "  },\n" +
            "    {\n" +
            "    \"id\": 10,\n" +
            "    \"kg\": 1.3\n" +
            "  }\n" +
            "]";


    //Inner classes
    // An object to help manage the steps array.
    class sortObj { //
        ArrayList<Integer> sortList = new ArrayList<Integer>();
    }

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
        for (int i = 0; i < only3kg_bags_Array.size(); i++) {
            finalResult += "ID:" + only3kg_bags_Array.get(i).getBagID() + "KG:" + only3kg_bags_Array.get(i).getBagSizeInKG() + "+\n";
        }

        ArrayList<BagObj> tempArray = new ArrayList<>();
        ArrayList<Integer> addedIds = new ArrayList<>();
        tempArray.addAll(under3kg_bags_Array);
        Collections.sort(tempArray, new Comparator<BagObj>() {
            @Override
            public int compare(BagObj lhs, BagObj rhs) {
                return Double.compare(lhs.getBagSizeInKG(),rhs.getBagSizeInKG());
            }
        });

        // try matching using two sum algo
        double target = 3.0;
        for (int i = 0; i < tempArray.size(); i++) {
            int[] twosumArray = indicesSumOfTwo(tempArray, target);
            if (twosumArray[0] != -1) {
                final_array.add(findBagById(under3kg_bags_Array, twosumArray[0]));
                final_array.add(findBagById(under3kg_bags_Array, twosumArray[1]));
                addedIds.add(twosumArray[0]);
                addedIds.add(twosumArray[1]);
                findAndRemoveByBagID(tempArray, twosumArray[0]);
                findAndRemoveByBagID(tempArray, twosumArray[1]);

            }
        }
        // Add to final String
        for(int i = 0 ; i < final_array.size() ; i+=2){
            finalResult+=" ID:"+final_array.get(i).getBagID()+" KG: "+final_array.get(i).getBagSizeInKG()+"  and  " +
                    ""+"ID: "+final_array.get(i+1).getBagID()+" KG: "+final_array.get(i+1).getBagSizeInKG()+"\n";
        }


/** disabled due to a bug I cannot figure now ( id miss-match ) , but it should had been part of the process.
 *
        // Try matching while looking for highest score for two.
        for(int i = 0 ; i < tempArray.size() ; i ++ ){
            int[] ids = getHigestScore(tempArray);
            BagObj bag1  = findBagById(tempArray,ids[0]);
            BagObj bag2  = findBagById(tempArray,ids[1]);
            finalResult += " ID: " + bag1.getBagID() + " KG: " + bag1.getBagSizeInKG()+" and "+" ID: " + bag2.getBagID() + " KG: " + bag2.getBagSizeInKG()+"\n";
            tempArray.remove(findBagById(tempArray,ids[0]));
            tempArray.remove(findBagById(tempArray,ids[1]));
        }
**/

        // try matching greedy for two or more
        if(tempArray.size()>1) {
            ArrayList<sortObj> stepsArray = new ArrayList<sortObj>(); // saving steps.
            double sum = 0;
            sortObj sumObj = new sortObj();
            for (int i = 0; i < tempArray.size(); i++) {
                sum += tempArray.get(i).getBagSizeInKG();
                if (sum > 3) {
                    stepsArray.add(sumObj);
                    i--;
                    sum = 0;
                    sumObj = new sortObj();
                } else if (sum < 3) {
                    sumObj.sortList.add(i);

                } else if (sum == 3) {
                    sumObj.sortList.add(i);
                    stepsArray.add(sumObj);
                    sum = 0;
                    sumObj = new sortObj();
                }
            }

            // Adding to final string.
            for (int i = 0; i < stepsArray.size(); i++) {
                finalResult += "\n";
                for (int j = 0; j < stepsArray.get(i).sortList.size(); j++) {
                    addedIds.add(tempArray.get(stepsArray.get(i).sortList.get(j)).getBagID());
                    if(j==0 || (j==1 & stepsArray.get(i).sortList.size()>2)){ // and and / and and and
                        finalResult += " ID: " + tempArray.get(stepsArray.get(i).sortList.get(j)).getBagID() + " KG: " + tempArray.get(stepsArray.get(i).sortList.get(j)).getBagSizeInKG()+" and ";
                    }else{
                        finalResult += " ID: " + tempArray.get(stepsArray.get(i).sortList.get(j)).getBagID() + " KG: " + tempArray.get(stepsArray.get(i).sortList.get(j)).getBagSizeInKG()+"\n";
                    }

                }
            }

            // Checking for missing bags.
            for(int i = 0 ; i < tempArray.size() ; i ++){
                if(!isIdAdded(addedIds , tempArray.get(i).getBagID())){
                    finalResult += "\n";
                    finalResult += " ID: " + tempArray.get(i).getBagID() + " KG: " + tempArray.get(i).getBagSizeInKG();
                }
            }
        }

        return finalResult;

    }

    // Finding the highest score of ( two bags) in the current bags stack . o(n^2)
    private int[] getHigestScore(ArrayList<BagObj> array){
        double highestScore = 0.0;
        int[] ids = new int[2];
        for(int i = 0 ; i < array.size() ; i ++){
            for(int j = 1; j < array.size()-1;j++){
                double sum = array.get(i).getBagSizeInKG()+array.get(j).getBagSizeInKG();
                if(sum==3){
                    sum = 0;
                }else if(sum>3){
                    sum = 0;
                }else if(sum<3 & sum>highestScore){
                    ids[0] = array.get(i).getBagID();
                    ids[1] = array.get(j).getBagID();
                    highestScore = sum;
                    sum = 0;
                }
            }
        }
        return ids;
    }


    // When  an array is with an odd size , the last object could be missing .
    private boolean isIdAdded(ArrayList<Integer> ArrayToCheck , int id){
        for(int i = 0 ; i < ArrayToCheck.size() ; i++){
            if(ArrayToCheck.get(i)==id){
                return true;
            }
        }
        return false;
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
        JSONArray jsonArray = new JSONArray(json_for_testing2);

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