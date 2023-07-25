package BoEBlockchain;

public class CalendarDays {
    public enum TradingHours {
        
        DAY_1("WEEKEND"),
        DAY_2("WEEKEND"),
        DAY_3("WEEK DAY"),
        DAY_4("WEEK DAY"),
        DAY_5("WEEK DAY"),
        DAY_6("WEEK DAY"),
        DAY_7("WEEK DAY"),
        DAY_8("WEEKEND"),
        DAY_9("WEEKEND"),
        DAY_10("WEEK DAY"),
        DAY_11("WEEK DAY"),
        DAY_12("WEEK DAY"),
        DAY_13("WEEK DAY"),
        DAY_14("WEEK DAY"),
        DAY_15("WEEKEND"),
        DAY_16("WEEKEND"),
        DAY_17("WEEK DAY"),
        DAY_18("WEEK DAY"),
        DAY_19("WEEK DAY"),
        DAY_20("WEEK DAY"),
        DAY_21("WEEK DAY"),
        DAY_22("WEEKEND"),
        DAY_23("WEEKEND"),
        DAY_24("WEEK DAY"),
        DAY_25("WEEK DAY"),
        DAY_26("WEEK DAY"),
        DAY_27("WEEK DAY"),
        DAY_28("WEEK DAY"),
        DAY_29("WEEKEND"),
        DAY_30("WEEKEND"),
        DAY_31("WEEK DAY"),
        DAY_263("FULL DAY"),
        DAY_264("FULL DAY"),
        DAY_265("FULL DAY"),
        DAY_266("FULL DAY"),
        DAY_267("CLOSED"),
        DAY_268("CLOSED"),
        DAY_269("FULL DAY"),
        DAY_270("FULL DAY"),
        DAY_271("FULL DAY"),
        DAY_272("FULL DAY"),
        DAY_273("FULL DAY"),
        DAY_274("CLOSED"),
        DAY_275("CLOSED"),
        DAY_276("FULL DAY"),
        DAY_277("FULL DAY"),
        DAY_278("FULL DAY"),
        DAY_279("FULL DAY"),
        DAY_280("FULL DAY"),
        DAY_281("CLOSED"),
        DAY_282("CLOSED"),
        DAY_283("FULL DAY"),
        DAY_284("FULL DAY"),
        DAY_285("FULL DAY"),
        DAY_286("FULL DAY"),
        DAY_287("FULL DAY"),
        DAY_288("CLOSED"),
        DAY_289("CLOSED"),
        DAY_290("FULL DAY"),
        DAY_291("FULL DAY"),
        DAY_292("FULL DAY"),
        DAY_293("FULL DAY"),
        DAY_294("FULL DAY"),
        DAY_295("CLOSED"),
        DAY_296("CLOSED"),
        DAY_297("FULL DAY"),
        DAY_298("FULL DAY"),
        DAY_299("FULL DAY"),
        DAY_300("FULL DAY"),
        DAY_301("FULL DAY"),
        DAY_302("CLOSED"),
        DAY_303("CLOSED"),
        DAY_304("FULL DAY"),
        DAY_305("FULL DAY"),
        DAY_306("FULL DAY"),
        DAY_307("FULL DAY"),
        DAY_308("FULL DAY"),
        DAY_309("CLOSED"),
        DAY_310("CLOSED"),
        DAY_311("FULL DAY"),
        DAY_312("FULL DAY"),
        DAY_313("FULL DAY"),
        DAY_314("FULL DAY"),
        DAY_315("FULL DAY"),
        DAY_316("CLOSED"),
        DAY_317("CLOSED"),
        DAY_318("FULL DAY"),
        DAY_319("FULL DAY"),
        DAY_320("FULL DAY"),
        DAY_321("FULL DAY"),
        DAY_322("FULL DAY"),
        DAY_323("CLOSED"),
        DAY_324("CLOSED"),
        DAY_325("FULL DAY"),
        DAY_326("FULL DAY"),
        DAY_327("FULL DAY"),
        DAY_328("FULL DAY"),
        DAY_329("SHORT DAY"),
        DAY_330("CLOSED"),
        DAY_331("CLOSED"),
        DAY_332("FULL DAY"),
        DAY_333("FULL DAY"),
        DAY_334("FULL DAY"),
        DAY_335("FULL DAY"),
        DAY_336("FULL DAY"),
        DAY_337("CLOSED"),
        DAY_338("CLOSED"),
        DAY_339("FULL DAY"),
        DAY_340("FULL DAY"),
        DAY_341("FULL DAY"),
        DAY_342("FULL DAY"),
        DAY_343("FULL DAY"),
        DAY_344("CLOSED"),
        DAY_345("CLOSED"),
        DAY_346("FULL DAY"),
        DAY_347("FULL DAY"),
        DAY_348("FULL DAY"),
        DAY_349("FULL DAY"),
        DAY_350("FULL DAY"),
        DAY_351("CLOSED"),
        DAY_352("CLOSED"),
        DAY_353("FULL DAY"),
        DAY_354("FULL DAY"),
        DAY_355("FULL DAY"),
        DAY_356("FULL DAY"),
        DAY_357("FULL DAY"),
        DAY_358("CLOSED"),
        DAY_359("CLOSED"),
        DAY_360("CLOSED"),
        DAY_361("FULL DAY"),
        DAY_362("FULL DAY"),
        DAY_363("FULL DAY"),
        DAY_364("FULL DAY"),
        DAY_365("CLOSED"),
        DAY_232("CLOSED"),
        DAY_233("CLOSED"),
        DAY_234("FULL DAY"),
        DAY_235("FULL DAY"),
        DAY_236("FULL DAY"),
        DAY_237("FULL DAY"),
        DAY_238("FULL DAY"),
        DAY_239("CLOSED"),
        DAY_240("CLOSED"),
        DAY_241("FULL DAY"),
        DAY_242("FULL DAY"),
        DAY_243("FULL DAY"),
        DAY_244("FULL DAY"),
        DAY_245("FULL DAY"),
        DAY_246("CLOSED"),
        DAY_247("CLOSED"),
        DAY_248("CLOSED"),
        DAY_249("FULL DAY"),
        DAY_250("FULL DAY"),
        DAY_251("FULL DAY"),
        DAY_252("FULL DAY"),
        DAY_253("CLOSED"),
        DAY_254("CLOSED"),
        DAY_255("FULL DAY"),
        DAY_256("FULL DAY"),
        DAY_257("FULL DAY"),
        DAY_258("FULL DAY"),
        DAY_259("FULL DAY"),
        DAY_260("CLOSED"),
        DAY_261("CLOSED"),
        DAY_262("FULL DAY"),
//        DAY_263("FULL DAY"),
//        DAY_264("FULL DAY"),
//        DAY_265("FULL DAY"),
//        DAY_266("FULL DAY"),
//        DAY_267("CLOSED"),
//        DAY_268("CLOSED"),
//        DAY_269("FULL DAY"),
//        DAY_270("FULL DAY"),
//        DAY_271("FULL DAY"),
//        DAY_272("FULL DAY"),
//        DAY_273("FULL DAY"),
//        DAY_274("CLOSED"),
//        DAY_275("CLOSED"),
//        DAY_276("FULL DAY"),
//        DAY_277("FULL DAY"),
//        DAY_278("FULL DAY"),
//        DAY_279("FULL DAY"),
//        DAY_280("FULL DAY"),
//        DAY_281("CLOSED"),
//        DAY_282("CLOSED"),
//        DAY_283("FULL DAY"),
//        DAY_284("FULL DAY"),
//        DAY_285("FULL DAY"),
//        DAY_286("FULL DAY"),
//        DAY_287("FULL DAY"),
//        DAY_288("CLOSED"),
//        DAY_289("CLOSED"),
//        DAY_290("FULL DAY"),
//        DAY_291("FULL DAY"),
//        DAY_292("FULL DAY"),
//        DAY_293("FULL DAY"),
//        DAY_294("FULL DAY"),
//        DAY_295("CLOSED"),
//        DAY_296("CLOSED"),
//        DAY_297("FULL DAY"),
//        DAY_298("FULL DAY"),
//        DAY_299("FULL DAY"),
//        DAY_300("FULL DAY"),
//        DAY_301("FULL DAY"),
//        DAY_302("CLOSED"),
//        DAY_303("CLOSED"),
//        DAY_304("FULL DAY"),
//        DAY_305("FULL DAY"),
//        DAY_306("FULL DAY"),
//        DAY_307("FULL DAY"),
//        DAY_308("FULL DAY"),
//        DAY_309("CLOSED"),
//        DAY_310("CLOSED"),
//        DAY_311("FULL DAY"),
//        DAY_312("FULL DAY"),
//        DAY_313("FULL DAY"),
//        DAY_314("FULL DAY"),
//        DAY_315("FULL DAY"),
//        DAY_316("CLOSED"),
//        DAY_317("CLOSED"),
//        DAY_318("FULL DAY"),
//        DAY_319("FULL DAY"),
//        DAY_320("FULL DAY"),
//        DAY_321("FULL DAY"),
//        DAY_322("FULL DAY"),
//        DAY_323("CLOSED"),
//        DAY_324("CLOSED"),
//        DAY_325("FULL DAY"),
//        DAY_326("FULL DAY"),
//        DAY_327("FULL DAY"),
//        DAY_328("FULL DAY"),
//        DAY_329("SHORT DAY"),
//        DAY_330("CLOSED"),
//        DAY_331("CLOSED"),
//        DAY_332("FULL DAY"),
//        DAY_333("FULL DAY"),
//        DAY_334("FULL DAY"),
//        DAY_335("FULL DAY"),
//        DAY_336("FULL DAY"),
//        DAY_337("CLOSED"),
//        DAY_338("CLOSED"),
//        DAY_339("FULL DAY"),
//        DAY_340("FULL DAY"),
//        DAY_341("FULL DAY"),
//        DAY_342("FULL DAY"),
//        DAY_343("FULL DAY"),
//        DAY_344("CLOSED"),
//        DAY_345("CLOSED"),
//        DAY_346("FULL DAY"),
//        DAY_347("FULL DAY"),
//        DAY_348("FULL DAY"),
//        DAY_349("FULL DAY"),
//        DAY_350("FULL DAY"),
//        DAY_351("CLOSED"),
//        DAY_352("CLOSED"),
//        DAY_353("FULL DAY"),
//        DAY_354("FULL DAY"),
//        DAY_355("FULL DAY"),
//        DAY_356("FULL DAY"),
//        DAY_357("FULL DAY"),
//        DAY_358("CLOSED"),
//        DAY_359("CLOSED"),
//        DAY_360("CLOSED"),
//        DAY_361("FULL DAY"),
//        DAY_362("FULL DAY"),
//        DAY_363("FULL DAY"),
//        DAY_364("FULL DAY"),
//        DAY_365("CLOSED")
        ;

        public String id;

        TradingHours(String id) {
            this.id = id;
        }
    }
}