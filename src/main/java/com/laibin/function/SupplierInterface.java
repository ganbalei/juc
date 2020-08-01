package com.laibin.function;

import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "leihaowa";
            }
        };

        Supplier<String> stringSupplier = ()->{ return "asdfasd";};

        supplier.get();
        stringSupplier.get();
    }
}
