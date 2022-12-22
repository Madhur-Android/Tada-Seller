package com.example.tadaseller.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.tadaseller.AppModals.Product;
import com.example.tadaseller.Dao.ProductDao;

@Database(entities = {Product.class},version = 3)
public abstract class ProductDatabase extends RoomDatabase
{
    private static ProductDatabase instance;

    public abstract ProductDao productDao();

    public static synchronized ProductDatabase getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    ProductDatabase.class,"product_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private ProductDao productDao;

        private PopulateDbAsyncTask(ProductDatabase db)
        {
            productDao=db.productDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //            productDao.insert(new Product(0,"shirt",100,3,true));
            //            we can add product to be already shown by the statement shown above

            return null;
        }
    }
}