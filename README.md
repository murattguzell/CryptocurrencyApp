
# Cyrpto Currencsy APP

Projenin amacı, bir API'den kripto para birimlerinin güncel verilerini (para birimi ve fiyat bilgisi) çekmek ve bu verileri kullanıcıya dinamik bir liste (RecyclerView) olarak sunmaktır. Proje, Retrofit ile bir API'den veri çekmeyi, bu verileri modellemeyi (data class) ve RecyclerView kullanarak listelemeyi içermektedir. Kullanıcı, listede bulunan kripto para birimlerine tıklayarak belirli etkileşimlerde bulunabilir (örneğin, Toast mesajı ile bilgilendirilir).

Bu proje, temel seviyede bir kripto para takip uygulaması olarak düşünülebilir ve API ile veri çekme, listeleme ve kullanıcı etkileşimlerini yönetme gibi konuları içermektedir.


## Özellikler
Bu uygulama, kullanıcıların anlık olarak kripto para birimlerinin fiyatlarını görüntüleyebileceği bir platform sunar. Kullanıcılar uygulama üzerinden şu özelliklerden faydalanabilirler:

- Kripto Para Listesi: Uygulama açıldığında, farklı kripto para birimlerinin isimlerini ve güncel fiyatlarını görebilirsiniz.

- Liste Üzerinde Etkileşim: Kripto para listesinde herhangi bir öğeye tıkladığınızda, seçtiğiniz kripto para biriminin ismi ekranda kısa bir mesaj olarak görünür.

- Renkli Liste: Listede yer alan her kripto para birimi farklı bir arka plan rengi ile gösterilir, bu sayede veriler daha kolay ayırt edilebilir.


  
## Kullanılan Teknolojiler

**Retrofit:**

Kullanım Amacı: HTTP isteklerini yönetmek ve API'den veri almak için kullanılır. Bu projede Retrofit ile kripto para API'sine istek gönderilir ve JSON verileri alınır.

**RxJava:**

Kullanım Amacı: Asenkron veri akışlarını yönetmek için kullanılır. API çağrısından dönen veriler asenkron olarak işlenir ve UI güncellemeleri yapılır.

**Gson:**

Kullanım Amacı: JSON verilerini Kotlin veri sınıflarına dönüştürmek için kullanılır. Retrofit ile gelen JSON verileri otomatik olarak CyriptoModel veri sınıfına çevrilir.

**RecyclerView:**

Kullanım Amacı: Dinamik olarak liste halinde veri göstermek için kullanılır. Bu projede kripto para bilgileri RecyclerView ile listelenir.

**LayoutInflater:**

Kullanım Amacı: XML layout dosyalarını View nesnelerine dönüştürmek için kullanılır. Bu projede öğe görünümlerini oluşturmak için cyripto_row.xml dosyası View olarak şişirilir.

**Color:**

Kullanım Amacı: Dinamik olarak arka plan rengini değiştirmek için kullanılır. Farklı kripto para öğelerine farklı renkler atanır.

**CompositeDisposable (RxJava):**

Kullanım Amacı: RxJava işlemlerini yönetmek ve gerektiğinde iptal etmek için kullanılır. API istekleri tamamlandığında veya hata oluştuğunda kullanılmayan kaynaklar serbest bırakılır.

**Data Class (Kotlin):**

Kullanım Amacı: Veri modelini tanımlamak için kullanılır. CyriptoModel, kripto para verilerini (para birimi ve fiyat) temsil eden veri sınıfıdır.
  
## Ekran Görüntüleri

|||||
|------------------|-----------------|
| ![Ekran 1](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/CyrptoCurrencyAPP/Ss1.png?raw=true) | ![Ekran 2](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/CyrptoCurrencyAPP/Ss2.png?raw=true)

  
