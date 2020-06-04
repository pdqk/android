package com.example.cloneshopee.network

import com.example.cloneshopee.home.models.homepageModel.SlideImageModel
import com.example.cloneshopee.home.models.homepageModel.VoucherModel
import com.example.cloneshopee.home.models.menuModel.ShopModel
import com.example.cloneshopee.home.models.menuModel.giatuiModel.GiatUiSlideImageModel
import com.example.cloneshopee.home.models.menuModel.giatuiModel.SubmenuGiatUiModel
import com.example.cloneshopee.home.models.menuModel.hoaModel.HoaSlideImageModel
import com.example.cloneshopee.home.models.menuModel.hoaModel.SubmenuHoaModel
import com.example.cloneshopee.home.models.menuModel.lamdepModel.LamDepSlideImageModel
import com.example.cloneshopee.home.models.menuModel.lamdepModel.SubmenuLamDepModel
import com.example.cloneshopee.home.models.menuModel.ruoubiaModel.RuouBiaSlideImageModel
import com.example.cloneshopee.home.models.menuModel.ruoubiaModel.SubmenuRuouBiaModel
import com.example.cloneshopee.home.models.menuModel.sieuthiModel.SieuThiSlideImageModel
import com.example.cloneshopee.home.models.menuModel.sieuthiModel.SubmenuSieuThiModel
import com.example.cloneshopee.home.models.menuModel.thucphamModel.SubmenuThucPhamModel
import com.example.cloneshopee.home.models.menuModel.thucphamModel.ThucPhamSlideImageModel
import com.example.cloneshopee.home.models.menuModel.thucungModel.SubmenuThuCungModel
import com.example.cloneshopee.home.models.menuModel.thucungModel.ThuCungSlideImageModel
import com.example.cloneshopee.home.models.menuModel.thuocModel.SubmenuThuocModel
import com.example.cloneshopee.home.models.menuModel.thuocModel.ThuocSlideImageModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://clone-now.herokuapp.com/api/v1.0/public/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface APIService {
    /**/
    /*Homepage API*/
    @GET("slideimages/all")
    fun getAllSlideImages():
            Deferred<List<SlideImageModel>>
    @GET("vouchers/all")
    fun getAllVouchers():
            Deferred<List<VoucherModel>>

    /**/
    /*API get submenu of menu in homepage*/
    @GET("submenus/thucpham")
    fun getAllSubmenuThucPham():
            Deferred<List<SubmenuThucPhamModel>>
    @GET("submenus/thucung")
    fun getAllSubmenuThuCung():
            Deferred<List<SubmenuThuCungModel>>
    @GET("submenus/sieuthi")
    fun getAllSubmenuSieuThi():
            Deferred<List<SubmenuSieuThiModel>>
    @GET("submenus/hoa")
    fun getAllSubmenuHoa():
            Deferred<List<SubmenuHoaModel>>
    @GET("submenus/ruoubia")
    fun getAllSubmenuRuouBia():
            Deferred<List<SubmenuRuouBiaModel>>
    @GET("submenus/thuoc")
    fun getAllSubmenuThuoc():
            Deferred<List<SubmenuThuocModel>>
    @GET("submenus/lamdep")
    fun getAllSubmenuLamDep():
            Deferred<List<SubmenuLamDepModel>>
    @GET("submenus/giatui")
    fun getAllSubmenuGiatUi():
            Deferred<List<SubmenuGiatUiModel>>

    /**/
    /*Submenu Thuc pham API*/
    @GET("thucphams/allSlideImage")
    fun getAllThucPhamSlideImage():
            Deferred<List<ThucPhamSlideImageModel>>
    @GET("thucphams/allSubMenuDacSan")
    fun getAllSubmenuDacSan():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuAnChay")
    fun getAllSubmenuAnChay():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuTraiCay")
    fun getAllSubmenuTraiCay():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuThitTrung")
    fun getAllSubmenuThitTrung():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuHaiSan")
    fun getAllSubmenuHaiSan():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuRauCu")
    fun getAllSubmenuRauCu():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuGaoMi")
    fun getAllSubmenuGaoMi():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuDoUongAnVat")
    fun getAllSubmenuDoUongAnVat():
            Deferred<List<ShopModel>>
    @GET("thucphams/allSubMenuGiaVi")
    fun getAllSubmenuGiaVi():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Thu cung API*/
    @GET("thucungs/allSlideImage")
    fun getAllThuCungSlideImage():
            Deferred<List<ThuCungSlideImageModel>>
    @GET("thucungs/allSubMenuThuCung")
    fun getAllSubmenuThuCungs():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Sieu thi API*/
    @GET("sieuthis/allSlideImage")
    fun getAllSieuThiSlideImage():
            Deferred<List<SieuThiSlideImageModel>>
    @GET("sieuthis/allSubMenuMyPham")
    fun getAllSubmenuMyPham():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuTaBim")
    fun getAllSubmenuTaBim():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuSua")
    fun getAllSubmenuSua():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuDoChoi")
    fun getAllSubmenuDoChoi():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuThietBi")
    fun getAllSubmenuThietBi():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuDungCu")
    fun getAllSubmenuDungCu():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuQuanAo")
    fun getAllSubmenuQuanAo():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuGiayDep")
    fun getAllSubmenuGiayDep():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuDienTu")
    fun getAllSubmenuDienTu():
            Deferred<List<ShopModel>>
    @GET("sieuthis/allSubMenuTrangSuc")
    fun getAllSubmenuTrangSuc():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Hoa API*/
    @GET("hoas/allSlideImage")
    fun getAllHoaSlideImage():
            Deferred<List<HoaSlideImageModel>>
    @GET("hoas/allSubMenuChucMung")
    fun getAllSubmenuChucMung():
            Deferred<List<ShopModel>>
    @GET("hoas/allSubMenuSinhNhat")
    fun getAllSubmenuSinhNhat():
            Deferred<List<ShopModel>>
    @GET("hoas/allSubMenuTinhYeu")
    fun getAllSubmenuTinhYeu():
            Deferred<List<ShopModel>>
    @GET("hoas/allSubMenuChiaBuon")
    fun getAllSubmenuChiaBuon():
            Deferred<List<ShopModel>>
    @GET("hoas/allSubMenuCayCanh")
    fun getAllSubmenuCayCanh():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Ruou bia API*/
    @GET("ruoubias/allSlideImage")
    fun getAllRuouBiaSlideImage():
            Deferred<List<RuouBiaSlideImageModel>>
    @GET("ruoubias/allSubMenuBia")
    fun getAllSubmenuBia():
            Deferred<List<ShopModel>>
    @GET("ruoubias/allSubMenuRuou")
    fun getAllSubmenuRuou():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Thuoc API*/
    @GET("thuocs/allSlideImage")
    fun getAllThuocSlideImage():
            Deferred<List<ThuocSlideImageModel>>
    @GET("thuocs/allSubMenuBCS")
    fun getAllSubmenuBCS():
            Deferred<List<ShopModel>>
    @GET("thuocs/allSubMenuVitamins")
    fun getAllSubmenuVitamins():
            Deferred<List<ShopModel>>
    @GET("thuocs/allSubMenuThuocTay")
    fun getAllSubmenuThuocTay():
            Deferred<List<ShopModel>>
    @GET("thuocs/allSubMenuThietBi")
    fun getAllSubmenuThietBiYTe():
            Deferred<List<ShopModel>>
    @GET("thuocs/allSubMenuKhauTrang")
    fun getAllSubmenuKhauTrang():
            Deferred<List<ShopModel>>
    @GET("thuocs/allSubMenuKhanCap")
    fun getAllSubmenuKhanCap():
            Deferred<List<ShopModel>>
    @GET("thuocs/allSubMenuHoaMyPham")
    fun getAllSubmenuHoaMyPham():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Hoa API*/
    @GET("lamdeps/allSlideImage")
    fun getAllLamDepSlideImage():
            Deferred<List<LamDepSlideImageModel>>
    @GET("lamdeps/allSubMenuNail")
    fun getAllSubmenuNail():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuMassage")
    fun getAllSubmenuMassage():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuToc")
    fun getAllSubmenuToc():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuDa")
    fun getAllSubmenuDa():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuPhongKham")
    fun getAllSubmenuPhongKham():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuNoiMi")
    fun getAllSubmenuNoiMi():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuTattoo")
    fun getAllSubmenuTattoo():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuNhaKhoa")
    fun getAllSubmenuNhaKhoa():
            Deferred<List<ShopModel>>
    @GET("lamdeps/allSubMenuMakeUp")
    fun getAllSubmenuMakeUp():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Giat ui API*/
    @GET("giatuis/allSlideImage")
    fun getAllGiatUiSlideImage():
            Deferred<List<GiatUiSlideImageModel>>
    @GET("giatuis/allSubMenuGiatUi")
    fun getAllSubmenuGiatUis():
            Deferred<List<ShopModel>>
    @GET("giatuis/allSubMenuGiay")
    fun getAllSubmenuGiay():
            Deferred<List<ShopModel>>
    @GET("giatuis/allSubMenuThuBong")
    fun getAllSubmenuThuBong():
            Deferred<List<ShopModel>>
    @GET("giatuis/allSubMenuGiatHap")
    fun getAllSubmenuGiatHap():
            Deferred<List<ShopModel>>
    @GET("giatuis/allSubMenuVeSinhCongNghiep")
    fun getAllSubmenuVeSinhCongNghiep():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu An vat API*/
    @GET("anvats/allMenuAnVat")
    fun getAllMenuAnVat():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Tra sua API*/
    @GET("trasuas/allMenuTraSua")
    fun getAllMenuTraSua():
            Deferred<List<ShopModel>>

    /**/
    /*Submenu Com API*/
    @GET("coms/allMenuCom")
    fun getAllMenuCom():
            Deferred<List<ShopModel>>
}

object API {
    val apiService : APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}