package com.global.api.tests.testdata;

import com.global.api.entities.EncryptionData;
import com.global.api.entities.enums.EbtCardType;
import com.global.api.entities.enums.EntryMethod;
import com.global.api.paymentMethods.*;

public class NtsTestCards {

    /**
     * SVS cards
     */

    public static GiftCard svsCard(){
        GiftCard card = new GiftCard();
        card.setValue(";6006491286999911672=691211072913941?");
        return card;
    }

    public static GiftCard svsCard2(){
        GiftCard card = new GiftCard();
        card.setValue(";6006491260550253006=711111073762752?");
        return card;
    }

    /**
     * Master cards
     */

    public static CreditTrackData MasterCardTrack1(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue("%B5473500000000014^MASTERCARD TEST^12251041234567890123?9");
        track.setEntryMethod(entryMethod);
        return track;
    }

    public static CreditTrackData MasterCardTrack2(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue(";5473500000000014=25121019999888877776?");
        track.setEntryMethod(entryMethod);
        return track;
    }

    public static CreditTrackData PropCardTrack2(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue(";6502702501812268=250650100200984?");
        track.setEntryMethod(entryMethod);
        return track;
    }

    /**
     * Visa Cards
     */

    public static CreditTrackData VisaTrack2(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue(";4012002000060016=12251011803939600000?");
        track.setEntryMethod(entryMethod);
        return track;
    }

    public static CreditTrackData VisaTrack1(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue("%B4012002000060016^VI TEST CREDIT^122510118039000000000396?");
        track.setEntryMethod(entryMethod);
        return track;
    }

    public static CreditTrackData Visa2Track1(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue("%B4484104292153662^POSINT TEST VISA P CARD^1225501032100321001000?");
        track.setEntryMethod(entryMethod);
        return track;
    }


    /**
     * Amex Cards
     */
    public static CreditTrackData AmexTrack2(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue(";372700699251018=25121019999888877776?");
        track.setEntryMethod(entryMethod);
        return track;
    }

    public static CreditTrackData AmexTrack1(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue("%B372700699251018^AMEX TEST CARD^2512990502700?");
        track.setEntryMethod(entryMethod);
        return track;
    }

    /**
     * Discover Cards
     */
    public static CreditTrackData DiscoverTrack2(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue(";6011000990156527=25121011000062111401?");
        track.setEntryMethod(entryMethod);
        return track;
    }

    public static CreditTrackData DiscoverTrack1(EntryMethod entryMethod){
        CreditTrackData track = new CreditTrackData();
        track.setValue("%B6011000990156527^DIS TEST CARD^2512990502700?");
        track.setEntryMethod(entryMethod);
        return track;
    }


    /**
     * EBT Cards
     */
    public static EBTTrackData EBTTrack2(EntryMethod entryMethod, EbtCardType ebtCardType){
        EBTTrackData cashTrack = new EBTTrackData(ebtCardType);
        cashTrack.setValue(";6004862001012758000=491200000000?");
        cashTrack.setPinBlock("1109D2058244FBC3");
        cashTrack.setEntryMethod(entryMethod);
        EncryptionData data = EncryptionData.version2("/wECAQEEAoFGAgEH4gcOTDT6jRZwb3NAc2VjdXJlZXhjaGFuZ2UubmV0m+/d4SO9TEshhRGUUQzVBrBvP/Os1qFx+6zdQp1ejjUCoDmzoUMbil9UG73zBxxTOy25f3Px0p8joyCh8PEWhADz1BkROJT3q6JnocQE49yYBHuFK0obm5kqUcYPfTY09vPOpmN+wp45gJY9PhkJF5XvPsMlcxX4/JhtCshegz4AYrcU/sFnI+nDwhy295BdOkVN1rn00jwCbRcE900kj3UsFfyc", "2");
        data.setKsn("A50401000440053F    ");
        cashTrack.setEncryptionData(data);
        return cashTrack;
    }

    public static EBTCardData getFoodCardManual() {
        EBTCardData card = new EBTCardData();
        card.setNumber("6004862001012758000");
        card.setPinBlock("142920FFFFFFFFFF");
        card.setExpYear(2049);
        card.setExpMonth(12);
        card.setEbtCardType(EbtCardType.FoodStamp);
        return card;
    }

    public static EBTCardData getCashCardManual() {
        EBTCardData card = new EBTCardData();
        card.setNumber("6004862001012758000");
        card.setPinBlock("142920FFFFFFFFFF");
        card.setExpYear(2049);
        card.setExpMonth(12);
        card.setEbtCardType(EbtCardType.CashBenefit);
        return card;
    }



}
