package com.aaratechnologies.fourcutss.Utils;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetDataServices {


    /*    _______________________X__________________________Simple User Section______________________X____________________________*/
    @POST("user/user_login")
    @FormUrlEncoded
    Call<ResponseBody> userLogin(
            @Field("mobile") String mobile,
            @Field("device_token") String device_token

    );

    @POST("common/register")
    @FormUrlEncoded
    Call<ResponseBody> registerVendor(
            @Field("username") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("common/shop_registration")
    @FormUrlEncoded
    Call<ResponseBody> shop_registration(
            @Field("apicall") String apicall,
            @Field("who") String who,
            @Field("shop_image") String shop_image,
            @Field("vendor_id") String vendor_id,
            @Field("shop_owner") String shop_owner,
            @Field("shop_address") String shop_address,
            @Field("shop_landmark") String shop_landmark,
            @Field("shop_latitude") double shop_latitude,
            @Field("shop_longitude") double shop_longitude,
            @Field("shop_city") String shop_city,
            @Field("shop_state") String shop_state,
            @Field("shop_country") String shop_country,
            @Field("shop_pin") String shop_pin,
            @Field("shop_gst") String shop_gst,
            @Field("shop_adhar") String shop_adhar,
            @Field("shop_mobile") String shop_mobile
    );

    @POST("common/login")
    @FormUrlEncoded
    Call<ResponseBody> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("common/profile/")
    @FormUrlEncoded
    Call<ResponseBody> updateUserProfile(
            @Field("what") String what,
            @Field("user_id") String user_id,
            @Field("image") String image,
            @Field("user_token") String user_token
    );

    @POST("common/subscribe_user")
    @FormUrlEncoded
    Call<ResponseBody> checkSubscriptionForUser(
            @Field("user_id") String user_id,
            @Field("vendor_id") String vendor_id
    );


    @POST("common/shop_time")
    @FormUrlEncoded
    Call<ResponseBody> showShopTimingOpenOrNot(
            @Field("id") String id,
            @Field("day") String day
    );

    @POST("common/profile/")
    @FormUrlEncoded
    Call<ResponseBody> updateUserContactDetail(
            @Field("what") String what,
            @Field("user_id") String user_id,
            @Field("mobile") String image,
            @Field("user_token") String user_token
    );

    @GET("common/show_profile/{id}")
    Call<ResponseBody> userProfileDetails(@Path("id") String id);


    @GET("common/shop_to_product/vendor_id/{id}")
    Call<ResponseBody> getVendorDetailsWithProducts(@Path("id") String id);


    @GET("common/subcategory/18")
    Call<ResponseBody> getCityDirectoryAccordingtoMegaCat(

    );

    @GET("service_seller/type_to_service/{id}")
    Call<ResponseBody> getCityDirectoryWiseShops(
            @Path("id") String id
    );


    @GET("common/sub_cat_brand/{id}")
    Call<ResponseBody> getShopListFromSubCategory(@Path("id") String id);


    @GET("common/product_view/{id}")
    Call<ResponseBody> getProuctdetailsUserPart(@Path("id") String id);

    @POST("service_seller/serivce_enable_slot")
    @FormUrlEncoded
    Call<ResponseBody> createSlots(
            @Field("vendor_id") String vendor_id,
            @Field("slot[]") String[] slot
    );

    /*    _______________________X________________________Product Seller Section___________________________X_________________________*/

    @POST("common/add_product")
    @FormUrlEncoded
    Call<ResponseBody> insertData(
            @Field("p_name") String product_name,
            @Field("p_old_price") String p_old_price,
            @Field("p_current_price") String p_current_price,
            @Field("p_qty") String p_qty,
            @Field("moq") String moq,
            @Field("image") String image,
            @Field("p_description") String p_description,
            @Field("p_short_description") String p_short_description,
            @Field("p_feature") String p_feature,
            @Field("p_condition") String p_condition,
            @Field("p_return_policy") String p_return_policy,
            @Field("product_expiry") String product_expiry,
            @Field("gst") String gst,
            @Field("color") String color,
            @Field("weight") String weight,
            @Field("size") String size,
            @Field("cat_id") String cat_id,
            @Field("sub_id") String sub_id,
            @Field("type_id") String type_id,
            @Field("vendor_id") String vendor_id
    );


    @GET("common/category")
    Call<ResponseBody> categoryList();


    @POST("common/shop_show")
    @FormUrlEncoded
    Call<ResponseBody> sellersList(
            @Field("shop_latitude") String lat,
            @Field("shop_longitude") String lang
    );


    @GET("common/plans")
    Call<ResponseBody> plansList();

    @POST("common/plans")
    @FormUrlEncoded
    Call<ResponseBody> plansList(
            @Field("plans_id") String plans_id,
            @Field("vendor_id") String vendor_id
    );

    @POST("common/brand")
    @FormUrlEncoded
    Call<ResponseBody> createBrand(
            @Field("brand_image") String brand_image,
            @Field("vendor_id") String vendor_id,
            @Field("brand_name") String brand_name,
            @Field("brand_category") String brand_category
    );

    @GET("common/subcategory/{id}")
    Call<ResponseBody> subcategoryList(@Path("id") String id);


    @GET("common/add_product/vendor_id/{id}")
    Call<ResponseBody> getVendorsProduct(
            @Path("id") String vendor_id
    );


    @GET("common/add_product/product_id/{id}")
    Call<ResponseBody> getProductView(
            @Path("id") String product_id
    );


    @GET("common/vendor_banner/vendor_id/{id}")
    Call<ResponseBody> getBanners(
            @Path("id") String vendor_id
    );

    @GET("common/logo/{id}")
    Call<ResponseBody> getLogoDetails(
            @Path("id") String vendor_id
    );

    @POST("common/logo")
    @FormUrlEncoded
//    https://project252.aaratechnologies.in/web/common/logo
    Call<ResponseBody> updateLogo(
            @Field("vendor_id") String vendor_id,
            @Field("image") String image
    );

    @GET("common/subscribe/{id}")
    Call<ResponseBody> getSubscribersList(
            @Path("id") String vendor_id
    );

    @GET("common/subscribe/user_id/{id}")
    Call<ResponseBody> getMySubscribedList(
            @Path("id") String userId
    );

    @GET("common/product_enquiry/{id}")
    Call<ResponseBody> getEnquiries(
            @Path("id") String vendor_id
    );

    @DELETE("common/vendor_banner/{id}`")
    Call<ResponseBody> deleteBanner(
            @Path("id") String vendorBannerId
    );

    @DELETE("common/add_product/{id}")
    Call<ResponseBody> deleteProduct(
            @Path("id") String product_id
    );

    @FormUrlEncoded
    @POST("common/edit_product")
    Call<ResponseBody> UpdateProductDetails(
            @Field("product_id") String product_id,
            @Field("p_name") String product_name,
            @Field("p_old_price") String p_old_price,
            @Field("p_current_price") String p_current_price,
            @Field("p_qty") String p_qty,
            @Field("moq") String moq,
            @Field("image") String image,
            @Field("p_description") String p_description,
            @Field("p_short_description") String p_short_description,
            @Field("p_feature") String p_feature,
            @Field("p_condition") String p_condition,
            @Field("p_return_policy") String p_return_policy,
            @Field("product_expiry") String product_expiry,
            @Field("gst") String gst,
            @Field("color") String color,
            @Field("weight") String weight,
            @Field("size") String size,
            @Field("cat_id") String cat_id,
            @Field("sub_id") String sub_id,
            @Field("type_id") String type_id,
            @Field("vendor_id") String vendor_id

    );

    @POST("common/shop_registration")
    @FormUrlEncoded
    Call<ResponseBody> updateSellerWorkingHours(
            @Field("who") String who,
            @Field("apicall") String apicall,
            @Field("vendor_id") String vendor_id,
            @Field("monday_opening") String monday_opening,
            @Field("tuesday_opening") String tuesday_opening,
            @Field("wednesday_opening") String wednesday_opening,
            @Field("thursday_opening") String thursday_opening,
            @Field("friday_opening") String friday_opening,
            @Field("saturday_opening") String saturday_opening,
            @Field("sunday_opening") String sunday_opening,
            @Field("monday_closing") String monday_closing,
            @Field("tuesday_closing") String tuesday_closing,
            @Field("wednesday_closing") String wednesday_closing,
            @Field("thursday_closing") String thursday_closing,
            @Field("friday_closing") String friday_closing,
            @Field("saturday_closing") String saturday_closing,
            @Field("sunday_closing") String sunday_closing
    );


    @FormUrlEncoded
    @POST("common/vendor_banner")
    Call<ResponseBody> uploadBanner(
            @Field("mega_type") String mega_type,
            @Field("vendor_id") String vendor_id,
            @Field("banner_title") String banner_title,
            @Field("banner_slogan") String banner_slogan,
            @Field("banner_resource") String banner_resource,
            @Field("banner_redirect") String banner_redirect
    );


    @FormUrlEncoded
    @POST("common/product_enquiery")
    Call<ResponseBody> SetProductEnquiry(
            @Field("product_id") String product_id,
            @Field("user_id") String user_id,
            @Field("vendor_id") String vendor_id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("subject") String subject,
            @Field("message") String message
    );





    /*________________x____________________________ MegaSeller Section___________________________x___________________________*/

    @POST("mega_seller/brand")
    @FormUrlEncoded
    Call<ResponseBody> createBrandMegaSeller(
            @Field("vendor_id") String vendor_id,
            @Field("brand_name") String brand_name,
            @Field("brand_category") String brand_category,
            @Field("brand_image") String brand_image
    );

    //    https://project252.aaratechnologies.in/web/share_product_seller/product_seller_profile

    /*    vendor_id,shop_mobile,shop_address,shop_latitude,shop_longitude,
    shop_city,shop_state,shop_country,shop_pin,shop_adhar*/
    @POST("share_product_seller/product_seller_profile")
    @FormUrlEncoded
    Call<ResponseBody> changeProfileDetails(
            @Field("vendor_id") String vendor_id,
            @Field("shop_mobile") String shop_mobile,
            @Field("shop_address") String shop_address,
            @Field("shop_latitude") double shop_latitude,
            @Field("shop_longitude") double shop_longitude,
            @Field("shop_city") String shop_city,
            @Field("shop_state") String shop_state,
            @Field("shop_country") String shop_country,
            @Field("shop_pin") String shop_pin,
            @Field("shop_adhar") String shop_adhar
    );


    @GET("mega_seller/mega_seller_profile/{id}")
    Call<ResponseBody> MegaSellerProfileShow(
            @Path("id") String vendor_id
    );


    @POST("mega_seller/mega_seller_registration")
    @FormUrlEncoded
    Call<ResponseBody> MegaSellerRegistration(
            @Field("apicall") String apicall,
            @Field("who") String who,
            @Field("shop_image") String shop_image,
            @Field("vendor_id") String vendor_id,
            @Field("shop_owner") String shop_owner,
            @Field("shop_address") String shop_address,
            @Field("shop_landmark") String shop_landmark,
            @Field("shop_latitude") double shop_latitude,
            @Field("shop_longitude") double shop_longitude,
            @Field("shop_city") String shop_city,
            @Field("shop_state") String shop_state,
            @Field("shop_country") String shop_country,
            @Field("shop_pin") String shop_pin,
            @Field("shop_gst") String shop_gst,
            @Field("shop_adhar") String shop_adhar,
            @Field("shop_mobile") String shop_mobile
    );

//    @POST("mega_seller/logo")
//    @FormUrlEncoded
//    Call<ResponseBody> MegaSellerLogoUpload(
//            @Field("vendor_id") String vendor_id,
//            @Part MultipartBody.Part part,
//            @Part("image") RequestBody requestBody
//    );

    @POST("mega_seller/mega_seller_add_product")
    @FormUrlEncoded
    Call<ResponseBody> MegaSellerAddProduct(
            @Field("image") String image,
            @Field("p_name") String p_name,
            @Field("p_old_price") String p_old_price,
            @Field("p_current_price") String p_current_price,
            @Field("quantity") String quantity,
            @Field("p_description") String p_description,
            @Field("p_short_description") String p_short_description,
            @Field("p_feature") String p_feature,
            @Field("p_condition") String p_condition,
            @Field("p_return_policy") String p_return_policy,
            @Field("product_expiry") String product_expiry,
            @Field("gst") String gst,
            @Field("color") String color,
            @Field("weight") String weight,
            @Field("size") String size,
            @Field("cat_id") String cat_id,
            @Field("vendor_id") String vendor_id
    );

    @POST("mega_seller/mega_seller_registration")
    @FormUrlEncoded
    Call<ResponseBody> updateMegaSellerWorkingHours(
            @Field("who") String who,
            @Field("apicall") String apicall,
            @Field("vendor_id") String vendor_id,
            @Field("monday_opening") String monday_opening,
            @Field("tuesday_opening") String tuesday_opening,
            @Field("wednesday_opening") String wednesday_opening,
            @Field("thursday_opening") String thursday_opening,
            @Field("friday_opening") String friday_opening,
            @Field("saturday_opening") String saturday_opening,
            @Field("sunday_opening") String sunday_opening,
            @Field("monday_closing") String monday_closing,
            @Field("tuesday_closing") String tuesday_closing,
            @Field("wednesday_closing") String wednesday_closing,
            @Field("thursday_closing") String thursday_closing,
            @Field("friday_closing") String friday_closing,
            @Field("saturday_closing") String saturday_closing,
            @Field("sunday_closing") String sunday_closing
    );

    @GET("mega_seller/category/mega_type_id/2")
    Call<ResponseBody> megaTypeCategories();


    @GET("mega_seller/mega_seller_add_product/vendor_id/{id}")
    Call<ResponseBody> getMegaSellerProducts(
            @Path("id") String vendor_id
    );

    @GET("mega_seller/mega_seller_add_product/product_id/{id}")
    Call<ResponseBody> getMegaSellerSpecificProduct(
            @Path("id") String product_id
    );

    @GET("mega_seller/mega_seller_profile/{id}")
    Call<ResponseBody> loadMegaSellerAllDetails(
            @Path("id") String vendor_id
    );

    /*    _________________________________SerVice Seller Part___________________________________*/
//    https://project252.aaratechnologies.in/web/service_seller/service_type

    @GET("service_seller/service_type")
    Call<ResponseBody> getServicesList();
//    https://project252.aaratechnologies.in/web/service_seller/service_registration

    @POST("service_seller/service_registration")
    @FormUrlEncoded
    Call<ResponseBody> serviceSellerRegistration(
            @Field("apicall") String apicall,
            @Field("who") String who,
            @Field("vendor_id") String vendor_id,
            @Field("service_name") String service_name,
            @Field("service_city") String service_city,
            @Field("service_mobile") String service_mobile,
            @Field("service_owner") String service_owner,
            @Field("service_address") String service_address,
            @Field("service_latitude") double service_latitude,
            @Field("service_langitude") double service_langitude,
            @Field("service_state") String service_state,
            @Field("service_country") String service_country,
            @Field("service_pin") String service_pin,
            @Field("service_type") String service_type,
            @Field("service_adhar") String service_adhar
    );

//    https://project252.aaratechnologies.in/web/service_seller/service_slot

    @POST("service_seller/service_slot")
    @FormUrlEncoded
    Call<ResponseBody> createSlotTiming(
            @Field("slot") String slot,
            @Field("start") String start,
            @Field("end") String end

    );

    @GET("mega_seller/order_history/vendor_id/{id}")
    Call<ResponseBody> commonLoadSellerAllOrders(
            @Path("id") String vendor_id
    );


    @GET("mega_seller/order_history/user_id/{id}")
    Call<ResponseBody> orderHistoryUserSide(
            @Path("id") String userId
    );

    @GET("service_seller/service_profile/{id}")
    Call<ResponseBody> getServiceSellerAllDetails(
            @Path("id") String vendor_id
    );
//    https://project252.aaratechnologies.in/web/service_seller/service_profile/40
//    https://project252.aaratechnologies.in/web/mega_seller/order_history/user_id/10

//    who=service
//            apicall=service_reg
//    vendor_id,service_name,service_owner,service_address,service_latitude,service_langitude,service_state,service_country,service_pin,service_type

    @POST("service_seller/service_profile")
    @FormUrlEncoded
    Call<ResponseBody> ServiceSellerProfileUpdate(
            @Field("vendor_id") String vendor_id,
            @Field("service_address") String service_address,
            @Field("service_adhar") String service_adhar,
            @Field("service_latitude") String service_latitude,
            @Field("service_langitude") String service_langitude,
            @Field("service_state") String service_state,
            @Field("service_country") String service_country,
            @Field("service_pin") String service_pin
    );

    @POST("service_seller/service_image")
    @FormUrlEncoded
    Call<ResponseBody> ServiceSellerProfileImage(
            @Field("image") String image,
            @Field("vendor_id") String vendor_id
    );


    @GET("common/vendor_to_social_link/{id}")
    Call<ResponseBody> getSocialMediaOfUser(
            @Path("id") String vendor_id
    );


    @GET("common/all_social_media_list")
    Call<ResponseBody> getAllSocialMediaList(
    );


    @GET("service_seller/slot_update/{id}")
    Call<ResponseBody> getSelectedSlots(
            @Path("id") String vendor_id
    );

    @GET("service_seller/slot_enable/{slot_id}")
    Call<ResponseBody> Enable_Disable_Slots(
            @Path("slot_id") String slot_id
    );



    /*_________________________________________Common___________________________________________ */

//    https://project252.aaratechnologies.in/web/common/gallery

    @POST("common/gallery")
    @FormUrlEncoded
    Call<ResponseBody> addGalleryImage(
            @Field("image") String image,
            @Field("vendor_id") String vendor_id
    );

    @GET("common/gallery/{id}")
    Call<ResponseBody> ShowGalleryList(
            @Path("id") String vendor_id
    );

    @DELETE("common/gallery/{id}")
    Call<ResponseBody> deleteGalleryImage(
            @Path("id") String galleryId
    );

    @GET("common/review_list/{id}")
    Call<ResponseBody> ShowReviewsList(
            @Path("id") String vendor_id
    );


    @GET("service_seller/service_seller_all_data/vendor_id/{id}")
    Call<ResponseBody> getAllDetailsofParticularServiceSeller(
            @Path("id") String vendor_id
    );

    //    https://project252.aaratechnologies.in/web/mega_seller/shop_to_product/vendor_id/3
    @GET("mega_seller/shop_to_product/vendor_id/{id}")
    Call<ResponseBody> getAllDetailsofParticularMegaSeller(
            @Path("id") String vendor_id
    );
//    mega_seller/shop_to_product/vendor_id/2

//    vendor_id,product_id,product_qty,order_slot,order_date,order_time

    //    https://project252.aaratechnologies.in/web/common/order
    @POST("common/order")
    @FormUrlEncoded
    Call<ResponseBody> bookOrderUser(
            @Field("vendor_id") String vendor_id,
            @Field("product_id") String product_id,
            @Field("user_id") String user_id,
            @Field("product_qty") String product_qty,
            @Field("order_slot") String order_slot,
            @Field("order_date") String order_date,
            @Field("order_time") String order_time

    );

    @POST("service_seller/service_book")
    @FormUrlEncoded
    Call<ResponseBody> bookServiceUser(
            @Field("vendor_id") String vendor_id,
            @Field("user_id") String user_id,
            @Field("alloted_slot") String alloted_slot,
            @Field("service_id") String service_id,
            @Field("book_date") String book_date,
            @Field("book_time") String book_time

    );
//    url:-https://project252.aaratechnologies.in/web/service_seller/service_book
//    key:-vendor_id,user_id,alloted_slot,service_id,book_date,book_time

//    https://project252.aaratechnologies.in/web/common/store_slot


    @GET("common/store_slot")
    Call<ResponseBody> getSlotsFromStores(
    );

    @POST("common/show_profile")
    @FormUrlEncoded
    Call<ResponseBody> userProfileEdit(
            @Field("user_id") String user_id,
            @Field("username") String username,
            @Field("address") String address,
            @Field("city") String city,
            @Field("zip") String zip,
            @Field("state") String state,
            @Field("country") String country,
            @Field("mobile") String mobile
    );

    //https://project252.aaratechnologies.in/web/common/service_enquiry/38
    @GET("common/service_enquiry/{id}")
    Call<ResponseBody> GetServiceEnquiries(
            @Path("id") String vendor_id
    );


    @POST("common/service_enquiry")
    @FormUrlEncoded
    Call<ResponseBody> userServiceEnquiry(
            @Field("service_id") String service_id,
            @Field("user_id") String user_id,
            @Field("vendor_id") String vendor_id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("subject") String subject,
            @Field("message") String message
    );

//    https://project252.aaratechnologies.in/web/common/service_enquiry

//    https://project252.aaratechnologies.in/web/mega_seller/order_history/user_id/32

    @GET("mega_seller/order_history/user_id/{id}")
    Call<ResponseBody> getOrderHistoryUser(
            @Path("id") String user_id
    );
    @GET("mega_seller/order_history/vendor_id/{id}")
    Call<ResponseBody> getOrderHistoryServiceSeller(
            @Path("id") String vendor_id
    );

    //    https://project252.aaratechnologies.in/web/common/offer_add
    @POST("common/vendor_to_social_link")
    @FormUrlEncoded
    Call<ResponseBody> addSocialMediaLink(
            @Field("vendor_id") String vendor_id,
            @Field("social_media_id") String social_mediaId,
            @Field("url") String url
    );
    @POST("common/offer_add")
    @FormUrlEncoded
    Call<ResponseBody> addOfferVendor(
            @Field("offer_name") String offer_name,
            @Field("offer_starting") String offer_starting,
            @Field("offer_end") String offer_end,
            @Field("vendor_id") String vendor_id
    );

    @DELETE("common/vendor_to_social_link/{vendor_social_id}")
    Call<ResponseBody> deleteSocialMediaId(
            @Path("vendor_social_id") String social_media_id
    );

    //https://project252.aaratechnologies.in/web/common/order_update
    @POST("common/order_update")
    @FormUrlEncoded
    Call<ResponseBody> OrderStatus(
            @Field("order_status") String order_status,
            @Field("order_id") String order_id
    );

    //https://project252.aaratechnologies.in/web/common/enquiry_reply
//    @POST("common/enquiry_reply")
//    @FormUrlEncoded
//    Call<ResponseBody> EnquiryReply(
//            @Field("enquiry_id") String enquiry_id,
//            @Field("message") String message
//    );

    @POST("user/user_verify")
    @FormUrlEncoded
    Call<ResponseBody> sendOPtpHere(
            @Field("user_id")String user_id,
            @Field("otp") String otp,
            @Field("device_token") String device_token
    );
}