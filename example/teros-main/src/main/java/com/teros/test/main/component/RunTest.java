package com.teros.test.main.component;

public class RunTest {

    public void execute()
    {
        try {
            Loader loader = new Loader();
            loader.loadComponent();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
