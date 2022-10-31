package com.revhalisi.appchurch.api.models;

public class PostModels {
   String title;
   String information;

   public PostModels(String title, String information) {
     this.title = title;
      this.information = information;
   }

   public String getTitle() {
      return title;
   }

   public String getInformation() {
      return information;
   }
}
