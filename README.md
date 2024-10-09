هل مللت من مشاهدة مقاطع الفيديو المفضلة لديك على اليوتيوب فقط عندما تكون متصلاً بالإنترنت؟

 هل تبحث عن طريقة سهلة لحفظ مقاطع الفيديو على هاتفك للتعديل عليها لاحقًا؟

تبحث عن أفضل تطبيق أندرويد لتنزيل فيديوهات اليوتيوب لكن لاتجده على متجر غوغل؟ 

هناك العديد من التطبيقات المتاحة، ولكن أيها الأفضل والأمن؟  

 لدي الحل المثالي لك!

الحل  الوحيد  هو ان  تبني تطبيقك الخاصة او الاستعانة بسورس كود جاهز  تغيرالتطبيق حسب احتياجاتك الخاصة

مميزات التطبيق =>

سرعة التنزيل: يحمل التطبيق الفيديوهات بسرعة فائقة، مما يوفر لك الوقت والجهد.
جودة عالية: يمكنك اختيار جودة الفيديو التي تناسبك، سواء كانت عالية الدقة أو بدقة أقل لحفظ مساحة التخزين.
تنسيقات مختلفة: يدعم التطبيق تنسيقات فيديو وصوت متنوعة، مما يتيح لك اختيار التنسيق المناسب لجهازك.
واجهة سهلة الاستخدام: يتميز التطبيق بواجهة بسيطة وسهلة الاستخدام، حتى المبتدئين يمكنهم استخدامه بسهولة.
الحفاظ على صيغة الملف: المشكل الشائع في تطبيقات تحميل الفيديو  وهي انعطاب الملف اثناء عملية التنزيل ... في هذا  التطبيق تجاوزنا هذه المشكلة لانه يدعم التنزيل المؤقت او السحابي 
لا تفوت فرصة تجربة هذا التطبيق المذهل واحصل على تجربة مشاهدة فيديوهات اليوتيوب المفضلة لديك في أي وقت وفي أي مكان!

باتباع هذا الدليل، ستتمكن من تنزيل أي مقطع فيديو من اليوتيوب بسهولة وسرعة.

ملاحظات هامة:

حقوق النشر: يجب أن تكون على دراية بحقوق النشر قبل تنزيل أي محتوى. لا تقم بتنزيل أو مشاركة المحتوى المحمي بحقوق النشر بدون إذن.
تحديثات التطبيقات: تأكد من استخدام أحدث إصدار من التطبيق لضمان أفضل أداء وأمان.
لبناء التطبيق يحتاج  منك على الاقل تقدير معرفة سطحية بالبرمجة او الريسكين السورس مبني على اصدار اخير من الكرادر كوتلين  gradle.kt يدعم اندرويد sdk 24 الى  sdk 34
 تاكد من انه لديك انتيليج  او اندرويد  ستوديو على حاسوبك وانك معرف  الجافا في حاسوبك على اصدار 21 jdk  لكي يعمل لديك  او اترك idea يقوم بالامر عنك 
android {
    namespace = "com.guercifzone.hity2ube"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.guercifzone.hity2ube"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

استخدمت جيسوب للمكتبات الخارجية الباقي افتراضي

dependencies {
    implementation ("org.jsoup:jsoup:1.18.1")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}


الداتا  التي نتعامل معها هي  التالي 
public class VideoLink {
    private String url;
    private String quality;
    private String format;
    private String thumbnail;
    private boolean isAudioAvailable;


في ملف الموديل ستجد التعامل مع الرابط  للتحميل والجودو ونوع الملف ثم الصورة وهل الملف يحتوي على صوت ام لا 

الان ركز معي  لانه  هذا  الكود  هو اساس البرنامج او نقول عليه محرك البرنامج 

 private void loadurl() {
        try {
            //https://www.youtube.com/shorts/ZTS3YLjI0XE"
            VideoDownloader.getInstance().getResults(this, editText.getText().toString(), new OnVideoFoundListener() {
                @Override
                public void onVideo(ArrayList<VideoLink> videos) {
                    for (int i = 0; i < videos.size(); i++) {
                        Log.e("size:", videos.get(i).isAudioAvailable() + " server url --> " + videos.get(i).getQuality() + " quality : " + videos.get(i).getUrl());
                        txturl.setText(videos.get(i).getUrl());
                        txturl.setTextColor(Color.BLUE);
                        txtquality.setText("Quality :"+videos.get(i).getQuality());
                        txtformat.setText("Format :"+videos.get(i).getFormat());

                    }
                }

                @Override
                public void onError(String error) {
                    Log.e("size", error);
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

في هذه الدالة ستجد اننا قمنا  بحساب حجم الفيديو  من خلال  الاستعانة بملف  الموديل videolinkقمنا بعدها  بربطه بنص textview  ثم نفس  الشيء  للجودة ونوع الملف  
