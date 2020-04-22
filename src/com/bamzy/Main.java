package com.bamzy;


public class Main {

        public static void main(String[] args) {
            Runtime.Version version = Runtime.Version.parse("10.0.1");
            printVersionInfo(version);
            String versionDate = System.getProperty("java.version.date");
            System.out.println("java.version.date: " + versionDate);

            String vendorVersion = System.getProperty("java.vendor.version");
            System.out.println("java.vendor.version: " + vendorVersion);
        }

        private static void printVersionInfo(Runtime.Version version) {
            int feature = version.feature();
            int interim = version.interim();
            int update = version.update();
            int patch = version.patch();
            System.out.printf(" feature: %s%n interim: %s%n update: %s%n patch: %s%n",
                    feature, interim, update, patch);
        }

}
