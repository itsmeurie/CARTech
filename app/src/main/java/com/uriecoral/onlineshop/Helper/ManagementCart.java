package com.uriecoral.onlineshop.Helper;

import android.content.Context;
import android.widget.Toast;

import com.uriecoral.onlineshop.Domain.PopularDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    /**
     * Insert a food item into the cart
     */
    public void insertFood(PopularDomain item){
        ArrayList<PopularDomain> listPop = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listPop.size(); i++) {
            if (listPop.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = 1;
                break;
            }
        }
        if (existAlready){
            listPop.get(n).setNumberinCart(item.getNumberinCart());
        }
        else {
            listPop.add(item);
        }
        tinyDB.putListObject("CartList", listPop);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    /**
     * Get the list of items in the cart
     */
    public ArrayList<PopularDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    /**
     * Decrease the quantity of a specific item in the cart
     */
    public void minusNumberItem(ArrayList<PopularDomain>listItem, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if (listItem.get(position).getNumberinCart()==1){
            listItem.remove(position);
        }
        else {
            listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart()-1);
        }
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener.change();
    }

    /**
     * Increase the quantity of a specific item in the cart
     */
    public void plusNumberItem(ArrayList<PopularDomain> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart()+1);
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener.change();
    }

    /**
     * Calculate the total fee of all items in the cart
     */
    public Double getTotalFee(){
        ArrayList<PopularDomain> listItem = getListCart();
        double fee = 0;
        for (int i = 0; i < listItem.size(); i++) {
            fee = fee + (listItem.get(i).getPrice() * listItem.get(i).getNumberinCart());
        }
        return fee;
    }
}
