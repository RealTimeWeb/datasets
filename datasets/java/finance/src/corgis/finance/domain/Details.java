package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * 
 */
public class Details {
	
    // int , noninsurance trust federal agency securities total
    private Integer noninsuranceTrustFederalAgencySecuritiesTotal;
    // int , insurance trust other securities
    private Integer insuranceTrustOtherSecurities;
    // int , noninsurance trust securities total
    private Integer noninsuranceTrustSecuritiesTotal;
    // int , federal veteran's education total
    private Integer federalVeteransEducationTotal;
    // int , welfare nec intergovernmental
    private Integer welfareNecIntergovernmental;
    // int , general equipment and land
    private Integer generalEquipmentAndLand;
    // int , insurance trust state and local securities total
    private Integer insuranceTrustStateAndLocalSecuritiesTotal;
    // int , correction nec intergovernmental
    private Integer correctionNecIntergovernmental;
    // int , noninsurance trust federal treasury securities total
    private Integer noninsuranceTrustFederalTreasurySecuritiesTotal;
    // int , natural resources nec total expenditure
    private Integer naturalResourcesNecTotalExpenditure;
    // int , long term debt issued-ng total
    private Integer longTermDebtIssuedNgTotal;
    // int , own hospitals total expenditure
    private Integer ownHospitalsTotalExpenditure;
    // int , general current operation
    private Integer generalCurrentOperation;
    // int , hospitals total current
    private Integer hospitalsTotalCurrent;
    // int , general public buildings total
    private Integer generalPublicBuildingsTotal;
    // int , higher education-auxilliary total expenditure
    private Integer higherEducationAuxilliaryTotalExpenditure;
    // int , airports total expenditure
    private Integer airportsTotalExpenditure;
    // int , agriculture intergovernmental
    private Integer agricultureIntergovernmental;
    // int , libraries total expenditure
    private Integer librariesTotalExpenditure;
    // int , central staff intergovernmental
    private Integer centralStaffIntergovernmental;
    // int , general control equipment and land
    private Integer generalControlEquipmentAndLand;
    // int , direct general expenditure
    private Integer directGeneralExpenditure;
    // int , water utility total expenditure
    private Integer waterUtilityTotalExpenditure;
    // int , hospitals total intergovernmental
    private Integer hospitalsTotalIntergovernmental;
    // int , parks total expenditure
    private Integer parksTotalExpenditure;
    // int , federal national defense total
    private Integer federalNationalDefenseTotal;
    // int , water transport intergovernmental
    private Integer waterTransportIntergovernmental;
    // int , transit utility total expenditure
    private Integer transitUtilityTotalExpenditure;
    // int , housing and community developement total expenditure
    private Integer housingAndCommunityDevelopementTotalExpenditure;
    // int , parking total
    private Integer parkingTotal;
    // int , education-nec intergovernmental
    private Integer educationNecIntergovernmental;
    // int , transit subsidy total expenditure
    private Integer transitSubsidyTotalExpenditure;
    // int , intergovernmental to townships
    private Integer intergovernmentalToTownships;
    // int , financial administration total
    private Integer financialAdministrationTotal;
    // int , long term debt outstanding-total
    private Integer longTermDebtOutstandingTotal;
    // int , categorical assistance intergovernmental
    private Integer categoricalAssistanceIntergovernmental;
    // int , legislative total expenditure
    private Integer legislativeTotalExpenditure;
    // int , long term debt retired-gob total
    private Integer longTermDebtRetiredGobTotal;
    // int , transit subsidy intergovernmental
    private Integer transitSubsidyIntergovernmental;
    // int , gas utility total expenditure
    private Integer gasUtilityTotalExpenditure;
    // int , education total
    private Integer educationTotal;
    // int , federal mineral resources total expenditure
    private Integer federalMineralResourcesTotalExpenditure;
    // int , libraries intergovernmental
    private Integer librariesIntergovernmental;
    // int , federal veteran's-other hospital intergovernmental
    private Integer federalVeteransOtherHospitalIntergovernmental;
    // int , highways construction total
    private Integer highwaysConstructionTotal;
    // int , higher education-nec intergovernmental
    private Integer higherEducationNecIntergovernmental;
    // int , employment security administration intergovernmental
    private Integer employmentSecurityAdministrationIntergovernmental;
    // int , water transport total expenditure
    private Integer waterTransportTotalExpenditure;
    // int , higher education-nec total expenditure
    private Integer higherEducationNecTotalExpenditure;
    // int , unemployment comp total cash and securities
    private Integer unemploymentCompTotalCashAndSecurities;
    // int , welfare vendor paymentstotal
    private Integer welfareVendorPaymentstotal;
    // int , federal mineral resources intergovernmental
    private Integer federalMineralResourcesIntergovernmental;
    // int , judicial total expenditure
    private Integer judicialTotalExpenditure;
    // int , public welfare intergovernmental
    private Integer publicWelfareIntergovernmental;
    // int , highways total expenditure
    private Integer highwaysTotalExpenditure;
    // int , federal energy total expenditure
    private Integer federalEnergyTotalExpenditure;
    // int , assistance and subsidies
    private Integer assistanceAndSubsidies;
    // int , federal farm credit total
    private Integer federalFarmCreditTotal;
    // int , other securities
    private Integer otherSecurities;
    // int , elementary secondary total expenditure
    private Integer elementarySecondaryTotalExpenditure;
    // int , elementary secondary intergovernmental
    private Integer elementarySecondaryIntergovernmental;
    // int , federal agriculture farm income total
    private Integer federalAgricultureFarmIncomeTotal;
    // int , interest on debt
    private Integer interestOnDebt;
    // int , general government nec total expenditure
    private Integer generalGovernmentNecTotalExpenditure;
    // int , education assistance and subsidies
    private Integer educationAssistanceAndSubsidies;
    // int , federal space research total
    private Integer federalSpaceResearchTotal;
    // int , long term debt-nonguaranteed total
    private Integer longTermDebtNonguaranteedTotal;
    // int , long term debt retired-unsp total
    private Integer longTermDebtRetiredUnspTotal;
    // int , state and local securities
    private Integer stateAndLocalSecurities;
    // int , long term debt issued-ffc total
    private Integer longTermDebtIssuedFfcTotal;
    // int , beginning long term debt total outstanding
    private Integer beginningLongTermDebtTotalOutstanding;
    // int , solid waste management total expenditure
    private Integer solidWasteManagementTotalExpenditure;
    // int , cash assistance total expenditure
    private Integer cashAssistanceTotalExpenditure;
    // int , unempoyment comp total expenditure
    private Integer unempoymentCompTotalExpenditure;
    // int , federal veteran's-other hospital expenditure
    private Integer federalVeteransOtherHospitalExpenditure;
    // int , equipment only
    private Integer equipmentOnly;
    // int , insurance trust federal agency securities
    private Integer insuranceTrustFederalAgencySecurities;
    // int , general control intergovernmental
    private Integer generalControlIntergovernmental;
    // int , liquor stores expenditure
    private Integer liquorStoresExpenditure;
    // int , intergovernmental to school districts
    private Integer intergovernmentalToSchoolDistricts;
    // int , borrowing total
    private Integer borrowingTotal;
    // int , health intergovernmental
    private Integer healthIntergovernmental;
    // int , employment security administration expenditure total
    private Integer employmentSecurityAdministrationExpenditureTotal;
    // int , intergovernmental to combined and unallocable
    private Integer intergovernmentalToCombinedAndUnallocable;
    // int , long term debt retired-ffc total
    private Integer longTermDebtRetiredFfcTotal;
    // int , noninsurance trust other securities total
    private Integer noninsuranceTrustOtherSecuritiesTotal;
    // int , toll highways total expenditure
    private Integer tollHighwaysTotalExpenditure;
    // int , natural resources construction
    private Integer naturalResourcesConstruction;
    // int , other noninsurance trust total
    private Integer otherNoninsuranceTrustTotal;
    // int , welfare institution total expenditure
    private Integer welfareInstitutionTotalExpenditure;
    // int , general construction
    private Integer generalConstruction;
    // int , fire protection intergovernmental
    private Integer fireProtectionIntergovernmental;
    // int , long term debt retired-nt total
    private Integer longTermDebtRetiredNtTotal;
    // int , natural resources direct
    private Integer naturalResourcesDirect;
    // int , hospital-other intergovernmental
    private Integer hospitalOtherIntergovernmental;
    // int , housing and community developement intergovernmental
    private Integer housingAndCommunityDevelopementIntergovernmental;
    // int , parking intergovernmental
    private Integer parkingIntergovernmental;
    // int , general government nec intergovernmental
    private Integer generalGovernmentNecIntergovernmental;
    // int , long term debt issued-gob total
    private Integer longTermDebtIssuedGobTotal;
    // int , regular highways intergovernmental
    private Integer regularHighwaysIntergovernmental;
    // int , parks intergovernmental
    private Integer parksIntergovernmental;
    // int , intergovernmental to local
    private Integer intergovernmentalToLocal;
    // int , long term debt-gob total
    private Integer longTermDebtGobTotal;
    // int , insurance trust
    private Integer insuranceTrust;
    // int , insurance trust cash and securities
    private Integer insuranceTrustCashAndSecurities;
    // int , regular highways total expenditure
    private Integer regularHighwaysTotalExpenditure;
    // int , federal energy intergovernmental
    private Integer federalEnergyIntergovernmental;
    // int , natural resources total
    private Integer naturalResourcesTotal;
    // int , central staff total expenditure
    private Integer centralStaffTotalExpenditure;
    // int , hospitals total equipment and land
    private Integer hospitalsTotalEquipmentAndLand;
    // int , federal health-veterans total
    private Integer federalHealthVeteransTotal;
    // int , highways direct
    private Integer highwaysDirect;
    // int , long term debt-ffc total
    private Integer longTermDebtFfcTotal;
    // int , general control construction
    private Integer generalControlConstruction;
    // int , general control current
    private Integer generalControlCurrent;
    // int , long term debt retired-ng total
    private Integer longTermDebtRetiredNgTotal;
    // int , police total expenditure
    private Integer policeTotalExpenditure;
    // int , public welfare direct expenditure
    private Integer publicWelfareDirectExpenditure;
    // int , federal postal service expendituretotal
    private Integer federalPostalServiceExpendituretotal;
    // int , natural resources equipment and land
    private Integer naturalResourcesEquipmentAndLand;
    // int , general capital outlay
    private Integer generalCapitalOutlay;
    // int , airports intergovernmental
    private Integer airportsIntergovernmental;
    // int , worker's comp total expenditure
    private Integer workersCompTotalExpenditure;
    // int , insurance trust cash and deposits
    private Integer insuranceTrustCashAndDeposits;
    // int , long term debt issued-nt total
    private Integer longTermDebtIssuedNtTotal;
    // int , hospital-other total expenditure
    private Integer hospitalOtherTotalExpenditure;
    // int , sewerage total expenditure
    private Integer sewerageTotalExpenditure;
    // int , direct expenditure
    private Integer directExpenditure;
    // int , federal veteran's education intergovernmental
    private Integer federalVeteransEducationIntergovernmental;
    // int , federal agriculture farm income intergovernmental
    private Integer federalAgricultureFarmIncomeIntergovernmental;
    // int , police intergovernmental
    private Integer policeIntergovernmental;
    // int , general equipment only
    private Integer generalEquipmentOnly;
    // int , correction  intergovernmental
    private Integer correctionIntergovernmental;
    // int , cash and deposits total
    private Integer cashAndDepositsTotal;
    // int , education construction
    private Integer educationConstruction;
    // int , insurance trust securities total
    private Integer insuranceTrustSecuritiesTotal;
    // int , intergovernmental expenditure
    private Integer intergovernmentalExpenditure;
    // int , fish and game intergovernmental
    private Integer fishAndGameIntergovernmental;
    // int , public welfare assistance and subsidies
    private Integer publicWelfareAssistanceAndSubsidies;
    // int , general interest total expenditure
    private Integer generalInterestTotalExpenditure;
    // int , protective inspection intergovernmental
    private Integer protectiveInspectionIntergovernmental;
    // int , correction nec total
    private Integer correctionNecTotal;
    // int , intergovernmental to counties
    private Integer intergovernmentalToCounties;
    // int , veteran's affairs total expenditure
    private Integer veteransAffairsTotalExpenditure;
    // int , interest on general debt
    private Integer interestOnGeneralDebt;
    // int , hospitals total expenditure
    private Integer hospitalsTotalExpenditure;
    // int , general support total expenditure
    private Integer generalSupportTotalExpenditure;
    // int , highways intergovernmental
    private Integer highwaysIntergovernmental;
    // int , sewerage intergovernmental
    private Integer sewerageIntergovernmental;
    // int , federal own veteran's hospital intergovernmental
    private Integer federalOwnVeteransHospitalIntergovernmental;
    // int , highways land and equipment
    private Integer highwaysLandAndEquipment;
    // int , utilities equipment and land
    private Integer utilitiesEquipmentAndLand;
    // int , long term debt-nt total
    private Integer longTermDebtNtTotal;
    // int , federal farm credit intergovernmental
    private Integer federalFarmCreditIntergovernmental;
    // int , bond fund total
    private Integer bondFundTotal;
    // int , electric utility total expenditure
    private Integer electricUtilityTotalExpenditure;
    // int , natural resources intergovernmental
    private Integer naturalResourcesIntergovernmental;
    // int , sinking fund total
    private Integer sinkingFundTotal;
    // int , education equipment
    private Integer educationEquipment;
    // int , intergovernmental to state
    private Integer intergovernmentalToState;
    // int , utilities current operation
    private Integer utilitiesCurrentOperation;
    // int , forestry intergovernmental
    private Integer forestryIntergovernmental;
    // int , intergovernmental to special districts
    private Integer intergovernmentalToSpecialDistricts;
    // int , utilities total expenditure
    private Integer utilitiesTotalExpenditure;
    // int , federal agency securities total
    private Integer federalAgencySecuritiesTotal;
    // int , general assistance and subsidies
    private Integer generalAssistanceAndSubsidies;
    // int , utilities construction
    private Integer utilitiesConstruction;
    // int , public welfare total expenditure
    private Integer publicWelfareTotalExpenditure;
    // int , securities total
    private Integer securitiesTotal;
    // int , correction institutions total
    private Integer correctionInstitutionsTotal;
    // int , long term debt issued-unsp total
    private Integer longTermDebtIssuedUnspTotal;
    // int , insurance trust federal  securities
    private Integer insuranceTrustFederalSecurities;
    // int , employee retirement total expenditure
    private Integer employeeRetirementTotalExpenditure;
    // int , public welfare equipment and land
    private Integer publicWelfareEquipmentAndLand;
    // int , intergovernmental to municipalities
    private Integer intergovernmentalToMunicipalities;
    // int , noninsurance trust cash and securities total
    private Integer noninsuranceTrustCashAndSecuritiesTotal;
    // int , forestry total expenditure
    private Integer forestryTotalExpenditure;
    // int , worker's comp total cash and securities
    private Integer workersCompTotalCashAndSecurities;
    // int , health total expenditure
    private Integer healthTotalExpenditure;
    // int , cash and securities total
    private Integer cashAndSecuritiesTotal;
    // int , fire protection total expenditure
    private Integer fireProtectionTotalExpenditure;
    // int , hospitals total construction
    private Integer hospitalsTotalConstruction;
    // int , agriculture total expenditure
    private Integer agricultureTotalExpenditure;
    // int , solid waste management intergovernmental
    private Integer solidWasteManagementIntergovernmental;
    // int , long term debt issued total
    private Integer longTermDebtIssuedTotal;
    // int , utilities interest total
    private Integer utilitiesInterestTotal;
    // int , education intergovernmental
    private Integer educationIntergovernmental;
    // int , federal national defense intergovernmental
    private Integer federalNationalDefenseIntergovernmental;
    // int , intergovernmental to federal
    private Integer intergovernmentalToFederal;
    // int , current operation
    private Integer currentOperation;
    // int , education-nec expenditure total
    private Integer educationNecExpenditureTotal;
    // int , welfare nec total expenditure
    private Integer welfareNecTotalExpenditure;
    // int , long term debt retired total
    private Integer longTermDebtRetiredTotal;
    // int , correction  total
    private Integer correctionTotal;
    // int , education equipment and land
    private Integer educationEquipmentAndLand;
    // int , noninsurance trust cash and deposits total
    private Integer noninsuranceTrustCashAndDepositsTotal;
    // int , financial administration intergovernmental
    private Integer financialAdministrationIntergovernmental;
    // int , employee retirement total cash and securities
    private Integer employeeRetirementTotalCashAndSecurities;
    // int , other insurance trust
    private Integer otherInsuranceTrust;
    // int , fish and game total expenditure
    private Integer fishAndGameTotalExpenditure;
    // int , federal health-veterans intergovernmental
    private Integer federalHealthVeteransIntergovernmental;
    // int , cash assistance intergovernmental
    private Integer cashAssistanceIntergovernmental;
    // int , federal own veteran's hospitalstotal
    private Integer federalOwnVeteransHospitalstotal;
    // int , protective inspection total expenditure
    private Integer protectiveInspectionTotalExpenditure;
    // int , other insurance trust total cash and securities
    private Integer otherInsuranceTrustTotalCashAndSecurities;
    // int , noninsurance trust state and local securities total
    private Integer noninsuranceTrustStateAndLocalSecuritiesTotal;
    // int , categorical assistance total expenditure
    private Integer categoricalAssistanceTotalExpenditure;
    // int , insurance trust total expenditure
    private Integer insuranceTrustTotalExpenditure;
    // int , general control total
    private Integer generalControlTotal;
    // int , public welfare other current operation
    private Integer publicWelfareOtherCurrentOperation;
    // int , public welfare construction
    private Integer publicWelfareConstruction;
    // int , federal treasury securities total
    private Integer federalTreasurySecuritiesTotal;
    // int , educationother current operation
    private Integer educationotherCurrentOperation;
    // int , federal space research intergovernmental
    private Integer federalSpaceResearchIntergovernmental;
    // int , judicial intergovernmental
    private Integer judicialIntergovernmental;
    
    
    /*
     * @return 
     */
    public Integer getNoninsuranceTrustFederalAgencySecuritiesTotal() {
        return this.noninsuranceTrustFederalAgencySecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustOtherSecurities() {
        return this.insuranceTrustOtherSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNoninsuranceTrustSecuritiesTotal() {
        return this.noninsuranceTrustSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalVeteransEducationTotal() {
        return this.federalVeteransEducationTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWelfareNecIntergovernmental() {
        return this.welfareNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralEquipmentAndLand() {
        return this.generalEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustStateAndLocalSecuritiesTotal() {
        return this.insuranceTrustStateAndLocalSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionNecIntergovernmental() {
        return this.correctionNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNoninsuranceTrustFederalTreasurySecuritiesTotal() {
        return this.noninsuranceTrustFederalTreasurySecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesNecTotalExpenditure() {
        return this.naturalResourcesNecTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtIssuedNgTotal() {
        return this.longTermDebtIssuedNgTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOwnHospitalsTotalExpenditure() {
        return this.ownHospitalsTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralCurrentOperation() {
        return this.generalCurrentOperation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHospitalsTotalCurrent() {
        return this.hospitalsTotalCurrent;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralPublicBuildingsTotal() {
        return this.generalPublicBuildingsTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHigherEducationAuxilliaryTotalExpenditure() {
        return this.higherEducationAuxilliaryTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAirportsTotalExpenditure() {
        return this.airportsTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAgricultureIntergovernmental() {
        return this.agricultureIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLibrariesTotalExpenditure() {
        return this.librariesTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCentralStaffIntergovernmental() {
        return this.centralStaffIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralControlEquipmentAndLand() {
        return this.generalControlEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDirectGeneralExpenditure() {
        return this.directGeneralExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWaterUtilityTotalExpenditure() {
        return this.waterUtilityTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHospitalsTotalIntergovernmental() {
        return this.hospitalsTotalIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getParksTotalExpenditure() {
        return this.parksTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalNationalDefenseTotal() {
        return this.federalNationalDefenseTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWaterTransportIntergovernmental() {
        return this.waterTransportIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTransitUtilityTotalExpenditure() {
        return this.transitUtilityTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHousingAndCommunityDevelopementTotalExpenditure() {
        return this.housingAndCommunityDevelopementTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getParkingTotal() {
        return this.parkingTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationNecIntergovernmental() {
        return this.educationNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTransitSubsidyTotalExpenditure() {
        return this.transitSubsidyTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToTownships() {
        return this.intergovernmentalToTownships;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFinancialAdministrationTotal() {
        return this.financialAdministrationTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtOutstandingTotal() {
        return this.longTermDebtOutstandingTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCategoricalAssistanceIntergovernmental() {
        return this.categoricalAssistanceIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLegislativeTotalExpenditure() {
        return this.legislativeTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtRetiredGobTotal() {
        return this.longTermDebtRetiredGobTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTransitSubsidyIntergovernmental() {
        return this.transitSubsidyIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGasUtilityTotalExpenditure() {
        return this.gasUtilityTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationTotal() {
        return this.educationTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalMineralResourcesTotalExpenditure() {
        return this.federalMineralResourcesTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLibrariesIntergovernmental() {
        return this.librariesIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalVeteransOtherHospitalIntergovernmental() {
        return this.federalVeteransOtherHospitalIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysConstructionTotal() {
        return this.highwaysConstructionTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHigherEducationNecIntergovernmental() {
        return this.higherEducationNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmploymentSecurityAdministrationIntergovernmental() {
        return this.employmentSecurityAdministrationIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWaterTransportTotalExpenditure() {
        return this.waterTransportTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHigherEducationNecTotalExpenditure() {
        return this.higherEducationNecTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnemploymentCompTotalCashAndSecurities() {
        return this.unemploymentCompTotalCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWelfareVendorPaymentstotal() {
        return this.welfareVendorPaymentstotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalMineralResourcesIntergovernmental() {
        return this.federalMineralResourcesIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getJudicialTotalExpenditure() {
        return this.judicialTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareIntergovernmental() {
        return this.publicWelfareIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysTotalExpenditure() {
        return this.highwaysTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalEnergyTotalExpenditure() {
        return this.federalEnergyTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAssistanceAndSubsidies() {
        return this.assistanceAndSubsidies;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalFarmCreditTotal() {
        return this.federalFarmCreditTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOtherSecurities() {
        return this.otherSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getElementarySecondaryTotalExpenditure() {
        return this.elementarySecondaryTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getElementarySecondaryIntergovernmental() {
        return this.elementarySecondaryIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalAgricultureFarmIncomeTotal() {
        return this.federalAgricultureFarmIncomeTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInterestOnDebt() {
        return this.interestOnDebt;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralGovernmentNecTotalExpenditure() {
        return this.generalGovernmentNecTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationAssistanceAndSubsidies() {
        return this.educationAssistanceAndSubsidies;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalSpaceResearchTotal() {
        return this.federalSpaceResearchTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtNonguaranteedTotal() {
        return this.longTermDebtNonguaranteedTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtRetiredUnspTotal() {
        return this.longTermDebtRetiredUnspTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getStateAndLocalSecurities() {
        return this.stateAndLocalSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtIssuedFfcTotal() {
        return this.longTermDebtIssuedFfcTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBeginningLongTermDebtTotalOutstanding() {
        return this.beginningLongTermDebtTotalOutstanding;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSolidWasteManagementTotalExpenditure() {
        return this.solidWasteManagementTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAssistanceTotalExpenditure() {
        return this.cashAssistanceTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnempoymentCompTotalExpenditure() {
        return this.unempoymentCompTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalVeteransOtherHospitalExpenditure() {
        return this.federalVeteransOtherHospitalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEquipmentOnly() {
        return this.equipmentOnly;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustFederalAgencySecurities() {
        return this.insuranceTrustFederalAgencySecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralControlIntergovernmental() {
        return this.generalControlIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLiquorStoresExpenditure() {
        return this.liquorStoresExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToSchoolDistricts() {
        return this.intergovernmentalToSchoolDistricts;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBorrowingTotal() {
        return this.borrowingTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHealthIntergovernmental() {
        return this.healthIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmploymentSecurityAdministrationExpenditureTotal() {
        return this.employmentSecurityAdministrationExpenditureTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToCombinedAndUnallocable() {
        return this.intergovernmentalToCombinedAndUnallocable;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtRetiredFfcTotal() {
        return this.longTermDebtRetiredFfcTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNoninsuranceTrustOtherSecuritiesTotal() {
        return this.noninsuranceTrustOtherSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTollHighwaysTotalExpenditure() {
        return this.tollHighwaysTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesConstruction() {
        return this.naturalResourcesConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOtherNoninsuranceTrustTotal() {
        return this.otherNoninsuranceTrustTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWelfareInstitutionTotalExpenditure() {
        return this.welfareInstitutionTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralConstruction() {
        return this.generalConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFireProtectionIntergovernmental() {
        return this.fireProtectionIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtRetiredNtTotal() {
        return this.longTermDebtRetiredNtTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesDirect() {
        return this.naturalResourcesDirect;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHospitalOtherIntergovernmental() {
        return this.hospitalOtherIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHousingAndCommunityDevelopementIntergovernmental() {
        return this.housingAndCommunityDevelopementIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getParkingIntergovernmental() {
        return this.parkingIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralGovernmentNecIntergovernmental() {
        return this.generalGovernmentNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtIssuedGobTotal() {
        return this.longTermDebtIssuedGobTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRegularHighwaysIntergovernmental() {
        return this.regularHighwaysIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getParksIntergovernmental() {
        return this.parksIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToLocal() {
        return this.intergovernmentalToLocal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtGobTotal() {
        return this.longTermDebtGobTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrust() {
        return this.insuranceTrust;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustCashAndSecurities() {
        return this.insuranceTrustCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRegularHighwaysTotalExpenditure() {
        return this.regularHighwaysTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalEnergyIntergovernmental() {
        return this.federalEnergyIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesTotal() {
        return this.naturalResourcesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCentralStaffTotalExpenditure() {
        return this.centralStaffTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHospitalsTotalEquipmentAndLand() {
        return this.hospitalsTotalEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalHealthVeteransTotal() {
        return this.federalHealthVeteransTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysDirect() {
        return this.highwaysDirect;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtFfcTotal() {
        return this.longTermDebtFfcTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralControlConstruction() {
        return this.generalControlConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralControlCurrent() {
        return this.generalControlCurrent;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtRetiredNgTotal() {
        return this.longTermDebtRetiredNgTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPoliceTotalExpenditure() {
        return this.policeTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareDirectExpenditure() {
        return this.publicWelfareDirectExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalPostalServiceExpendituretotal() {
        return this.federalPostalServiceExpendituretotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesEquipmentAndLand() {
        return this.naturalResourcesEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralCapitalOutlay() {
        return this.generalCapitalOutlay;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAirportsIntergovernmental() {
        return this.airportsIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWorkersCompTotalExpenditure() {
        return this.workersCompTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustCashAndDeposits() {
        return this.insuranceTrustCashAndDeposits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtIssuedNtTotal() {
        return this.longTermDebtIssuedNtTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHospitalOtherTotalExpenditure() {
        return this.hospitalOtherTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSewerageTotalExpenditure() {
        return this.sewerageTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDirectExpenditure() {
        return this.directExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalVeteransEducationIntergovernmental() {
        return this.federalVeteransEducationIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalAgricultureFarmIncomeIntergovernmental() {
        return this.federalAgricultureFarmIncomeIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPoliceIntergovernmental() {
        return this.policeIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralEquipmentOnly() {
        return this.generalEquipmentOnly;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionIntergovernmental() {
        return this.correctionIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAndDepositsTotal() {
        return this.cashAndDepositsTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationConstruction() {
        return this.educationConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustSecuritiesTotal() {
        return this.insuranceTrustSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalExpenditure() {
        return this.intergovernmentalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFishAndGameIntergovernmental() {
        return this.fishAndGameIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareAssistanceAndSubsidies() {
        return this.publicWelfareAssistanceAndSubsidies;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralInterestTotalExpenditure() {
        return this.generalInterestTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getProtectiveInspectionIntergovernmental() {
        return this.protectiveInspectionIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionNecTotal() {
        return this.correctionNecTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToCounties() {
        return this.intergovernmentalToCounties;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getVeteransAffairsTotalExpenditure() {
        return this.veteransAffairsTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInterestOnGeneralDebt() {
        return this.interestOnGeneralDebt;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHospitalsTotalExpenditure() {
        return this.hospitalsTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralSupportTotalExpenditure() {
        return this.generalSupportTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysIntergovernmental() {
        return this.highwaysIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSewerageIntergovernmental() {
        return this.sewerageIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalOwnVeteransHospitalIntergovernmental() {
        return this.federalOwnVeteransHospitalIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysLandAndEquipment() {
        return this.highwaysLandAndEquipment;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesEquipmentAndLand() {
        return this.utilitiesEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtNtTotal() {
        return this.longTermDebtNtTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalFarmCreditIntergovernmental() {
        return this.federalFarmCreditIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBondFundTotal() {
        return this.bondFundTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getElectricUtilityTotalExpenditure() {
        return this.electricUtilityTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesIntergovernmental() {
        return this.naturalResourcesIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSinkingFundTotal() {
        return this.sinkingFundTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationEquipment() {
        return this.educationEquipment;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToState() {
        return this.intergovernmentalToState;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesCurrentOperation() {
        return this.utilitiesCurrentOperation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getForestryIntergovernmental() {
        return this.forestryIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToSpecialDistricts() {
        return this.intergovernmentalToSpecialDistricts;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesTotalExpenditure() {
        return this.utilitiesTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalAgencySecuritiesTotal() {
        return this.federalAgencySecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralAssistanceAndSubsidies() {
        return this.generalAssistanceAndSubsidies;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesConstruction() {
        return this.utilitiesConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareTotalExpenditure() {
        return this.publicWelfareTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSecuritiesTotal() {
        return this.securitiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionInstitutionsTotal() {
        return this.correctionInstitutionsTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtIssuedUnspTotal() {
        return this.longTermDebtIssuedUnspTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustFederalSecurities() {
        return this.insuranceTrustFederalSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployeeRetirementTotalExpenditure() {
        return this.employeeRetirementTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareEquipmentAndLand() {
        return this.publicWelfareEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToMunicipalities() {
        return this.intergovernmentalToMunicipalities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNoninsuranceTrustCashAndSecuritiesTotal() {
        return this.noninsuranceTrustCashAndSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getForestryTotalExpenditure() {
        return this.forestryTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWorkersCompTotalCashAndSecurities() {
        return this.workersCompTotalCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHealthTotalExpenditure() {
        return this.healthTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAndSecuritiesTotal() {
        return this.cashAndSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFireProtectionTotalExpenditure() {
        return this.fireProtectionTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHospitalsTotalConstruction() {
        return this.hospitalsTotalConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAgricultureTotalExpenditure() {
        return this.agricultureTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSolidWasteManagementIntergovernmental() {
        return this.solidWasteManagementIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtIssuedTotal() {
        return this.longTermDebtIssuedTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesInterestTotal() {
        return this.utilitiesInterestTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationIntergovernmental() {
        return this.educationIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalNationalDefenseIntergovernmental() {
        return this.federalNationalDefenseIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToFederal() {
        return this.intergovernmentalToFederal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCurrentOperation() {
        return this.currentOperation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationNecExpenditureTotal() {
        return this.educationNecExpenditureTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWelfareNecTotalExpenditure() {
        return this.welfareNecTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongTermDebtRetiredTotal() {
        return this.longTermDebtRetiredTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionTotal() {
        return this.correctionTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationEquipmentAndLand() {
        return this.educationEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNoninsuranceTrustCashAndDepositsTotal() {
        return this.noninsuranceTrustCashAndDepositsTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFinancialAdministrationIntergovernmental() {
        return this.financialAdministrationIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployeeRetirementTotalCashAndSecurities() {
        return this.employeeRetirementTotalCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOtherInsuranceTrust() {
        return this.otherInsuranceTrust;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFishAndGameTotalExpenditure() {
        return this.fishAndGameTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalHealthVeteransIntergovernmental() {
        return this.federalHealthVeteransIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAssistanceIntergovernmental() {
        return this.cashAssistanceIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalOwnVeteransHospitalstotal() {
        return this.federalOwnVeteransHospitalstotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getProtectiveInspectionTotalExpenditure() {
        return this.protectiveInspectionTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOtherInsuranceTrustTotalCashAndSecurities() {
        return this.otherInsuranceTrustTotalCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNoninsuranceTrustStateAndLocalSecuritiesTotal() {
        return this.noninsuranceTrustStateAndLocalSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCategoricalAssistanceTotalExpenditure() {
        return this.categoricalAssistanceTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustTotalExpenditure() {
        return this.insuranceTrustTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralControlTotal() {
        return this.generalControlTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareOtherCurrentOperation() {
        return this.publicWelfareOtherCurrentOperation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareConstruction() {
        return this.publicWelfareConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalTreasurySecuritiesTotal() {
        return this.federalTreasurySecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationotherCurrentOperation() {
        return this.educationotherCurrentOperation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalSpaceResearchIntergovernmental() {
        return this.federalSpaceResearchIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getJudicialIntergovernmental() {
        return this.judicialIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Details.
	
	 * @return String
	 */
	public String toString() {
		return "Details[" +noninsuranceTrustFederalAgencySecuritiesTotal+", "+insuranceTrustOtherSecurities+", "+noninsuranceTrustSecuritiesTotal+", "+federalVeteransEducationTotal+", "+welfareNecIntergovernmental+", "+generalEquipmentAndLand+", "+insuranceTrustStateAndLocalSecuritiesTotal+", "+correctionNecIntergovernmental+", "+noninsuranceTrustFederalTreasurySecuritiesTotal+", "+naturalResourcesNecTotalExpenditure+", "+longTermDebtIssuedNgTotal+", "+ownHospitalsTotalExpenditure+", "+generalCurrentOperation+", "+hospitalsTotalCurrent+", "+generalPublicBuildingsTotal+", "+higherEducationAuxilliaryTotalExpenditure+", "+airportsTotalExpenditure+", "+agricultureIntergovernmental+", "+librariesTotalExpenditure+", "+centralStaffIntergovernmental+", "+generalControlEquipmentAndLand+", "+directGeneralExpenditure+", "+waterUtilityTotalExpenditure+", "+hospitalsTotalIntergovernmental+", "+parksTotalExpenditure+", "+federalNationalDefenseTotal+", "+waterTransportIntergovernmental+", "+transitUtilityTotalExpenditure+", "+housingAndCommunityDevelopementTotalExpenditure+", "+parkingTotal+", "+educationNecIntergovernmental+", "+transitSubsidyTotalExpenditure+", "+intergovernmentalToTownships+", "+financialAdministrationTotal+", "+longTermDebtOutstandingTotal+", "+categoricalAssistanceIntergovernmental+", "+legislativeTotalExpenditure+", "+longTermDebtRetiredGobTotal+", "+transitSubsidyIntergovernmental+", "+gasUtilityTotalExpenditure+", "+educationTotal+", "+federalMineralResourcesTotalExpenditure+", "+librariesIntergovernmental+", "+federalVeteransOtherHospitalIntergovernmental+", "+highwaysConstructionTotal+", "+higherEducationNecIntergovernmental+", "+employmentSecurityAdministrationIntergovernmental+", "+waterTransportTotalExpenditure+", "+higherEducationNecTotalExpenditure+", "+unemploymentCompTotalCashAndSecurities+", "+welfareVendorPaymentstotal+", "+federalMineralResourcesIntergovernmental+", "+judicialTotalExpenditure+", "+publicWelfareIntergovernmental+", "+highwaysTotalExpenditure+", "+federalEnergyTotalExpenditure+", "+assistanceAndSubsidies+", "+federalFarmCreditTotal+", "+otherSecurities+", "+elementarySecondaryTotalExpenditure+", "+elementarySecondaryIntergovernmental+", "+federalAgricultureFarmIncomeTotal+", "+interestOnDebt+", "+generalGovernmentNecTotalExpenditure+", "+educationAssistanceAndSubsidies+", "+federalSpaceResearchTotal+", "+longTermDebtNonguaranteedTotal+", "+longTermDebtRetiredUnspTotal+", "+stateAndLocalSecurities+", "+longTermDebtIssuedFfcTotal+", "+beginningLongTermDebtTotalOutstanding+", "+solidWasteManagementTotalExpenditure+", "+cashAssistanceTotalExpenditure+", "+unempoymentCompTotalExpenditure+", "+federalVeteransOtherHospitalExpenditure+", "+equipmentOnly+", "+insuranceTrustFederalAgencySecurities+", "+generalControlIntergovernmental+", "+liquorStoresExpenditure+", "+intergovernmentalToSchoolDistricts+", "+borrowingTotal+", "+healthIntergovernmental+", "+employmentSecurityAdministrationExpenditureTotal+", "+intergovernmentalToCombinedAndUnallocable+", "+longTermDebtRetiredFfcTotal+", "+noninsuranceTrustOtherSecuritiesTotal+", "+tollHighwaysTotalExpenditure+", "+naturalResourcesConstruction+", "+otherNoninsuranceTrustTotal+", "+welfareInstitutionTotalExpenditure+", "+generalConstruction+", "+fireProtectionIntergovernmental+", "+longTermDebtRetiredNtTotal+", "+naturalResourcesDirect+", "+hospitalOtherIntergovernmental+", "+housingAndCommunityDevelopementIntergovernmental+", "+parkingIntergovernmental+", "+generalGovernmentNecIntergovernmental+", "+longTermDebtIssuedGobTotal+", "+regularHighwaysIntergovernmental+", "+parksIntergovernmental+", "+intergovernmentalToLocal+", "+longTermDebtGobTotal+", "+insuranceTrust+", "+insuranceTrustCashAndSecurities+", "+regularHighwaysTotalExpenditure+", "+federalEnergyIntergovernmental+", "+naturalResourcesTotal+", "+centralStaffTotalExpenditure+", "+hospitalsTotalEquipmentAndLand+", "+federalHealthVeteransTotal+", "+highwaysDirect+", "+longTermDebtFfcTotal+", "+generalControlConstruction+", "+generalControlCurrent+", "+longTermDebtRetiredNgTotal+", "+policeTotalExpenditure+", "+publicWelfareDirectExpenditure+", "+federalPostalServiceExpendituretotal+", "+naturalResourcesEquipmentAndLand+", "+generalCapitalOutlay+", "+airportsIntergovernmental+", "+workersCompTotalExpenditure+", "+insuranceTrustCashAndDeposits+", "+longTermDebtIssuedNtTotal+", "+hospitalOtherTotalExpenditure+", "+sewerageTotalExpenditure+", "+directExpenditure+", "+federalVeteransEducationIntergovernmental+", "+federalAgricultureFarmIncomeIntergovernmental+", "+policeIntergovernmental+", "+generalEquipmentOnly+", "+correctionIntergovernmental+", "+cashAndDepositsTotal+", "+educationConstruction+", "+insuranceTrustSecuritiesTotal+", "+intergovernmentalExpenditure+", "+fishAndGameIntergovernmental+", "+publicWelfareAssistanceAndSubsidies+", "+generalInterestTotalExpenditure+", "+protectiveInspectionIntergovernmental+", "+correctionNecTotal+", "+intergovernmentalToCounties+", "+veteransAffairsTotalExpenditure+", "+interestOnGeneralDebt+", "+hospitalsTotalExpenditure+", "+generalSupportTotalExpenditure+", "+highwaysIntergovernmental+", "+sewerageIntergovernmental+", "+federalOwnVeteransHospitalIntergovernmental+", "+highwaysLandAndEquipment+", "+utilitiesEquipmentAndLand+", "+longTermDebtNtTotal+", "+federalFarmCreditIntergovernmental+", "+bondFundTotal+", "+electricUtilityTotalExpenditure+", "+naturalResourcesIntergovernmental+", "+sinkingFundTotal+", "+educationEquipment+", "+intergovernmentalToState+", "+utilitiesCurrentOperation+", "+forestryIntergovernmental+", "+intergovernmentalToSpecialDistricts+", "+utilitiesTotalExpenditure+", "+federalAgencySecuritiesTotal+", "+generalAssistanceAndSubsidies+", "+utilitiesConstruction+", "+publicWelfareTotalExpenditure+", "+securitiesTotal+", "+correctionInstitutionsTotal+", "+longTermDebtIssuedUnspTotal+", "+insuranceTrustFederalSecurities+", "+employeeRetirementTotalExpenditure+", "+publicWelfareEquipmentAndLand+", "+intergovernmentalToMunicipalities+", "+noninsuranceTrustCashAndSecuritiesTotal+", "+forestryTotalExpenditure+", "+workersCompTotalCashAndSecurities+", "+healthTotalExpenditure+", "+cashAndSecuritiesTotal+", "+fireProtectionTotalExpenditure+", "+hospitalsTotalConstruction+", "+agricultureTotalExpenditure+", "+solidWasteManagementIntergovernmental+", "+longTermDebtIssuedTotal+", "+utilitiesInterestTotal+", "+educationIntergovernmental+", "+federalNationalDefenseIntergovernmental+", "+intergovernmentalToFederal+", "+currentOperation+", "+educationNecExpenditureTotal+", "+welfareNecTotalExpenditure+", "+longTermDebtRetiredTotal+", "+correctionTotal+", "+educationEquipmentAndLand+", "+noninsuranceTrustCashAndDepositsTotal+", "+financialAdministrationIntergovernmental+", "+employeeRetirementTotalCashAndSecurities+", "+otherInsuranceTrust+", "+fishAndGameTotalExpenditure+", "+federalHealthVeteransIntergovernmental+", "+cashAssistanceIntergovernmental+", "+federalOwnVeteransHospitalstotal+", "+protectiveInspectionTotalExpenditure+", "+otherInsuranceTrustTotalCashAndSecurities+", "+noninsuranceTrustStateAndLocalSecuritiesTotal+", "+categoricalAssistanceTotalExpenditure+", "+insuranceTrustTotalExpenditure+", "+generalControlTotal+", "+publicWelfareOtherCurrentOperation+", "+publicWelfareConstruction+", "+federalTreasurySecuritiesTotal+", "+educationotherCurrentOperation+", "+federalSpaceResearchIntergovernmental+", "+judicialIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Details from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Details(JSONObject json_data) {
        try {// noninsurance trust federal agency securities total
            this.noninsuranceTrustFederalAgencySecuritiesTotal = new Integer(((Long)json_data.get("noninsurance trust federal agency securities total")).intValue());// insurance trust other securities
            this.insuranceTrustOtherSecurities = new Integer(((Long)json_data.get("insurance trust other securities")).intValue());// noninsurance trust securities total
            this.noninsuranceTrustSecuritiesTotal = new Integer(((Long)json_data.get("noninsurance trust securities total")).intValue());// federal veteran's education total
            this.federalVeteransEducationTotal = new Integer(((Long)json_data.get("federal veteran's education total")).intValue());// welfare nec intergovernmental
            this.welfareNecIntergovernmental = new Integer(((Long)json_data.get("welfare nec intergovernmental")).intValue());// general equipment and land
            this.generalEquipmentAndLand = new Integer(((Long)json_data.get("general equipment and land")).intValue());// insurance trust state and local securities total
            this.insuranceTrustStateAndLocalSecuritiesTotal = new Integer(((Long)json_data.get("insurance trust state and local securities total")).intValue());// correction nec intergovernmental
            this.correctionNecIntergovernmental = new Integer(((Long)json_data.get("correction nec intergovernmental")).intValue());// noninsurance trust federal treasury securities total
            this.noninsuranceTrustFederalTreasurySecuritiesTotal = new Integer(((Long)json_data.get("noninsurance trust federal treasury securities total")).intValue());// natural resources nec total expenditure
            this.naturalResourcesNecTotalExpenditure = new Integer(((Long)json_data.get("natural resources nec total expenditure")).intValue());// long term debt issued-ng total
            this.longTermDebtIssuedNgTotal = new Integer(((Long)json_data.get("long term debt issued-ng total")).intValue());// own hospitals total expenditure
            this.ownHospitalsTotalExpenditure = new Integer(((Long)json_data.get("own hospitals total expenditure")).intValue());// general current operation
            this.generalCurrentOperation = new Integer(((Long)json_data.get("general current operation")).intValue());// hospitals total current
            this.hospitalsTotalCurrent = new Integer(((Long)json_data.get("hospitals total current")).intValue());// general public buildings total
            this.generalPublicBuildingsTotal = new Integer(((Long)json_data.get("general public buildings total")).intValue());// higher education-auxilliary total expenditure
            this.higherEducationAuxilliaryTotalExpenditure = new Integer(((Long)json_data.get("higher education-auxilliary total expenditure")).intValue());// airports total expenditure
            this.airportsTotalExpenditure = new Integer(((Long)json_data.get("airports total expenditure")).intValue());// agriculture intergovernmental
            this.agricultureIntergovernmental = new Integer(((Long)json_data.get("agriculture intergovernmental")).intValue());// libraries total expenditure
            this.librariesTotalExpenditure = new Integer(((Long)json_data.get("libraries total expenditure")).intValue());// central staff intergovernmental
            this.centralStaffIntergovernmental = new Integer(((Long)json_data.get("central staff intergovernmental")).intValue());// general control equipment and land
            this.generalControlEquipmentAndLand = new Integer(((Long)json_data.get("general control equipment and land")).intValue());// direct general expenditure
            this.directGeneralExpenditure = new Integer(((Long)json_data.get("direct general expenditure")).intValue());// water utility total expenditure
            this.waterUtilityTotalExpenditure = new Integer(((Long)json_data.get("water utility total expenditure")).intValue());// hospitals total intergovernmental
            this.hospitalsTotalIntergovernmental = new Integer(((Long)json_data.get("hospitals total intergovernmental")).intValue());// parks total expenditure
            this.parksTotalExpenditure = new Integer(((Long)json_data.get("parks total expenditure")).intValue());// federal national defense total
            this.federalNationalDefenseTotal = new Integer(((Long)json_data.get("federal national defense total")).intValue());// water transport intergovernmental
            this.waterTransportIntergovernmental = new Integer(((Long)json_data.get("water transport intergovernmental")).intValue());// transit utility total expenditure
            this.transitUtilityTotalExpenditure = new Integer(((Long)json_data.get("transit utility total expenditure")).intValue());// housing and community developement total expenditure
            this.housingAndCommunityDevelopementTotalExpenditure = new Integer(((Long)json_data.get("housing and community developement total expenditure")).intValue());// parking total
            this.parkingTotal = new Integer(((Long)json_data.get("parking total")).intValue());// education-nec intergovernmental
            this.educationNecIntergovernmental = new Integer(((Long)json_data.get("education-nec intergovernmental")).intValue());// transit subsidy total expenditure
            this.transitSubsidyTotalExpenditure = new Integer(((Long)json_data.get("transit subsidy total expenditure")).intValue());// intergovernmental to townships
            this.intergovernmentalToTownships = new Integer(((Long)json_data.get("intergovernmental to townships")).intValue());// financial administration total
            this.financialAdministrationTotal = new Integer(((Long)json_data.get("financial administration total")).intValue());// long term debt outstanding-total
            this.longTermDebtOutstandingTotal = new Integer(((Long)json_data.get("long term debt outstanding-total")).intValue());// categorical assistance intergovernmental
            this.categoricalAssistanceIntergovernmental = new Integer(((Long)json_data.get("categorical assistance intergovernmental")).intValue());// legislative total expenditure
            this.legislativeTotalExpenditure = new Integer(((Long)json_data.get("legislative total expenditure")).intValue());// long term debt retired-gob total
            this.longTermDebtRetiredGobTotal = new Integer(((Long)json_data.get("long term debt retired-gob total")).intValue());// transit subsidy intergovernmental
            this.transitSubsidyIntergovernmental = new Integer(((Long)json_data.get("transit subsidy intergovernmental")).intValue());// gas utility total expenditure
            this.gasUtilityTotalExpenditure = new Integer(((Long)json_data.get("gas utility total expenditure")).intValue());// education total
            this.educationTotal = new Integer(((Long)json_data.get("education total")).intValue());// federal mineral resources total expenditure
            this.federalMineralResourcesTotalExpenditure = new Integer(((Long)json_data.get("federal mineral resources total expenditure")).intValue());// libraries intergovernmental
            this.librariesIntergovernmental = new Integer(((Long)json_data.get("libraries intergovernmental")).intValue());// federal veteran's-other hospital intergovernmental
            this.federalVeteransOtherHospitalIntergovernmental = new Integer(((Long)json_data.get("federal veteran's-other hospital intergovernmental")).intValue());// highways construction total
            this.highwaysConstructionTotal = new Integer(((Long)json_data.get("highways construction total")).intValue());// higher education-nec intergovernmental
            this.higherEducationNecIntergovernmental = new Integer(((Long)json_data.get("higher education-nec intergovernmental")).intValue());// employment security administration intergovernmental
            this.employmentSecurityAdministrationIntergovernmental = new Integer(((Long)json_data.get("employment security administration intergovernmental")).intValue());// water transport total expenditure
            this.waterTransportTotalExpenditure = new Integer(((Long)json_data.get("water transport total expenditure")).intValue());// higher education-nec total expenditure
            this.higherEducationNecTotalExpenditure = new Integer(((Long)json_data.get("higher education-nec total expenditure")).intValue());// unemployment comp total cash and securities
            this.unemploymentCompTotalCashAndSecurities = new Integer(((Long)json_data.get("unemployment comp total cash and securities")).intValue());// welfare vendor paymentstotal
            this.welfareVendorPaymentstotal = new Integer(((Long)json_data.get("welfare vendor paymentstotal")).intValue());// federal mineral resources intergovernmental
            this.federalMineralResourcesIntergovernmental = new Integer(((Long)json_data.get("federal mineral resources intergovernmental")).intValue());// judicial total expenditure
            this.judicialTotalExpenditure = new Integer(((Long)json_data.get("judicial total expenditure")).intValue());// public welfare intergovernmental
            this.publicWelfareIntergovernmental = new Integer(((Long)json_data.get("public welfare intergovernmental")).intValue());// highways total expenditure
            this.highwaysTotalExpenditure = new Integer(((Long)json_data.get("highways total expenditure")).intValue());// federal energy total expenditure
            this.federalEnergyTotalExpenditure = new Integer(((Long)json_data.get("federal energy total expenditure")).intValue());// assistance and subsidies
            this.assistanceAndSubsidies = new Integer(((Long)json_data.get("assistance and subsidies")).intValue());// federal farm credit total
            this.federalFarmCreditTotal = new Integer(((Long)json_data.get("federal farm credit total")).intValue());// other securities
            this.otherSecurities = new Integer(((Long)json_data.get("other securities")).intValue());// elementary secondary total expenditure
            this.elementarySecondaryTotalExpenditure = new Integer(((Long)json_data.get("elementary secondary total expenditure")).intValue());// elementary secondary intergovernmental
            this.elementarySecondaryIntergovernmental = new Integer(((Long)json_data.get("elementary secondary intergovernmental")).intValue());// federal agriculture farm income total
            this.federalAgricultureFarmIncomeTotal = new Integer(((Long)json_data.get("federal agriculture farm income total")).intValue());// interest on debt
            this.interestOnDebt = new Integer(((Long)json_data.get("interest on debt")).intValue());// general government nec total expenditure
            this.generalGovernmentNecTotalExpenditure = new Integer(((Long)json_data.get("general government nec total expenditure")).intValue());// education assistance and subsidies
            this.educationAssistanceAndSubsidies = new Integer(((Long)json_data.get("education assistance and subsidies")).intValue());// federal space research total
            this.federalSpaceResearchTotal = new Integer(((Long)json_data.get("federal space research total")).intValue());// long term debt-nonguaranteed total
            this.longTermDebtNonguaranteedTotal = new Integer(((Long)json_data.get("long term debt-nonguaranteed total")).intValue());// long term debt retired-unsp total
            this.longTermDebtRetiredUnspTotal = new Integer(((Long)json_data.get("long term debt retired-unsp total")).intValue());// state and local securities
            this.stateAndLocalSecurities = new Integer(((Long)json_data.get("state and local securities")).intValue());// long term debt issued-ffc total
            this.longTermDebtIssuedFfcTotal = new Integer(((Long)json_data.get("long term debt issued-ffc total")).intValue());// beginning long term debt total outstanding
            this.beginningLongTermDebtTotalOutstanding = new Integer(((Long)json_data.get("beginning long term debt total outstanding")).intValue());// solid waste management total expenditure
            this.solidWasteManagementTotalExpenditure = new Integer(((Long)json_data.get("solid waste management total expenditure")).intValue());// cash assistance total expenditure
            this.cashAssistanceTotalExpenditure = new Integer(((Long)json_data.get("cash assistance total expenditure")).intValue());// unempoyment comp total expenditure
            this.unempoymentCompTotalExpenditure = new Integer(((Long)json_data.get("unempoyment comp total expenditure")).intValue());// federal veteran's-other hospital expenditure
            this.federalVeteransOtherHospitalExpenditure = new Integer(((Long)json_data.get("federal veteran's-other hospital expenditure")).intValue());// equipment only
            this.equipmentOnly = new Integer(((Long)json_data.get("equipment only")).intValue());// insurance trust federal agency securities
            this.insuranceTrustFederalAgencySecurities = new Integer(((Long)json_data.get("insurance trust federal agency securities")).intValue());// general control intergovernmental
            this.generalControlIntergovernmental = new Integer(((Long)json_data.get("general control intergovernmental")).intValue());// liquor stores expenditure
            this.liquorStoresExpenditure = new Integer(((Long)json_data.get("liquor stores expenditure")).intValue());// intergovernmental to school districts
            this.intergovernmentalToSchoolDistricts = new Integer(((Long)json_data.get("intergovernmental to school districts")).intValue());// borrowing total
            this.borrowingTotal = new Integer(((Long)json_data.get("borrowing total")).intValue());// health intergovernmental
            this.healthIntergovernmental = new Integer(((Long)json_data.get("health intergovernmental")).intValue());// employment security administration expenditure total
            this.employmentSecurityAdministrationExpenditureTotal = new Integer(((Long)json_data.get("employment security administration expenditure total")).intValue());// intergovernmental to combined and unallocable
            this.intergovernmentalToCombinedAndUnallocable = new Integer(((Long)json_data.get("intergovernmental to combined and unallocable")).intValue());// long term debt retired-ffc total
            this.longTermDebtRetiredFfcTotal = new Integer(((Long)json_data.get("long term debt retired-ffc total")).intValue());// noninsurance trust other securities total
            this.noninsuranceTrustOtherSecuritiesTotal = new Integer(((Long)json_data.get("noninsurance trust other securities total")).intValue());// toll highways total expenditure
            this.tollHighwaysTotalExpenditure = new Integer(((Long)json_data.get("toll highways total expenditure")).intValue());// natural resources construction
            this.naturalResourcesConstruction = new Integer(((Long)json_data.get("natural resources construction")).intValue());// other noninsurance trust total
            this.otherNoninsuranceTrustTotal = new Integer(((Long)json_data.get("other noninsurance trust total")).intValue());// welfare institution total expenditure
            this.welfareInstitutionTotalExpenditure = new Integer(((Long)json_data.get("welfare institution total expenditure")).intValue());// general construction
            this.generalConstruction = new Integer(((Long)json_data.get("general construction")).intValue());// fire protection intergovernmental
            this.fireProtectionIntergovernmental = new Integer(((Long)json_data.get("fire protection intergovernmental")).intValue());// long term debt retired-nt total
            this.longTermDebtRetiredNtTotal = new Integer(((Long)json_data.get("long term debt retired-nt total")).intValue());// natural resources direct
            this.naturalResourcesDirect = new Integer(((Long)json_data.get("natural resources direct")).intValue());// hospital-other intergovernmental
            this.hospitalOtherIntergovernmental = new Integer(((Long)json_data.get("hospital-other intergovernmental")).intValue());// housing and community developement intergovernmental
            this.housingAndCommunityDevelopementIntergovernmental = new Integer(((Long)json_data.get("housing and community developement intergovernmental")).intValue());// parking intergovernmental
            this.parkingIntergovernmental = new Integer(((Long)json_data.get("parking intergovernmental")).intValue());// general government nec intergovernmental
            this.generalGovernmentNecIntergovernmental = new Integer(((Long)json_data.get("general government nec intergovernmental")).intValue());// long term debt issued-gob total
            this.longTermDebtIssuedGobTotal = new Integer(((Long)json_data.get("long term debt issued-gob total")).intValue());// regular highways intergovernmental
            this.regularHighwaysIntergovernmental = new Integer(((Long)json_data.get("regular highways intergovernmental")).intValue());// parks intergovernmental
            this.parksIntergovernmental = new Integer(((Long)json_data.get("parks intergovernmental")).intValue());// intergovernmental to local
            this.intergovernmentalToLocal = new Integer(((Long)json_data.get("intergovernmental to local")).intValue());// long term debt-gob total
            this.longTermDebtGobTotal = new Integer(((Long)json_data.get("long term debt-gob total")).intValue());// insurance trust
            this.insuranceTrust = new Integer(((Long)json_data.get("insurance trust")).intValue());// insurance trust cash and securities
            this.insuranceTrustCashAndSecurities = new Integer(((Long)json_data.get("insurance trust cash and securities")).intValue());// regular highways total expenditure
            this.regularHighwaysTotalExpenditure = new Integer(((Long)json_data.get("regular highways total expenditure")).intValue());// federal energy intergovernmental
            this.federalEnergyIntergovernmental = new Integer(((Long)json_data.get("federal energy intergovernmental")).intValue());// natural resources total
            this.naturalResourcesTotal = new Integer(((Long)json_data.get("natural resources total")).intValue());// central staff total expenditure
            this.centralStaffTotalExpenditure = new Integer(((Long)json_data.get("central staff total expenditure")).intValue());// hospitals total equipment and land
            this.hospitalsTotalEquipmentAndLand = new Integer(((Long)json_data.get("hospitals total equipment and land")).intValue());// federal health-veterans total
            this.federalHealthVeteransTotal = new Integer(((Long)json_data.get("federal health-veterans total")).intValue());// highways direct
            this.highwaysDirect = new Integer(((Long)json_data.get("highways direct")).intValue());// long term debt-ffc total
            this.longTermDebtFfcTotal = new Integer(((Long)json_data.get("long term debt-ffc total")).intValue());// general control construction
            this.generalControlConstruction = new Integer(((Long)json_data.get("general control construction")).intValue());// general control current
            this.generalControlCurrent = new Integer(((Long)json_data.get("general control current")).intValue());// long term debt retired-ng total
            this.longTermDebtRetiredNgTotal = new Integer(((Long)json_data.get("long term debt retired-ng total")).intValue());// police total expenditure
            this.policeTotalExpenditure = new Integer(((Long)json_data.get("police total expenditure")).intValue());// public welfare direct expenditure
            this.publicWelfareDirectExpenditure = new Integer(((Long)json_data.get("public welfare direct expenditure")).intValue());// federal postal service expendituretotal
            this.federalPostalServiceExpendituretotal = new Integer(((Long)json_data.get("federal postal service expendituretotal")).intValue());// natural resources equipment and land
            this.naturalResourcesEquipmentAndLand = new Integer(((Long)json_data.get("natural resources equipment and land")).intValue());// general capital outlay
            this.generalCapitalOutlay = new Integer(((Long)json_data.get("general capital outlay")).intValue());// airports intergovernmental
            this.airportsIntergovernmental = new Integer(((Long)json_data.get("airports intergovernmental")).intValue());// worker's comp total expenditure
            this.workersCompTotalExpenditure = new Integer(((Long)json_data.get("worker's comp total expenditure")).intValue());// insurance trust cash and deposits
            this.insuranceTrustCashAndDeposits = new Integer(((Long)json_data.get("insurance trust cash and deposits")).intValue());// long term debt issued-nt total
            this.longTermDebtIssuedNtTotal = new Integer(((Long)json_data.get("long term debt issued-nt total")).intValue());// hospital-other total expenditure
            this.hospitalOtherTotalExpenditure = new Integer(((Long)json_data.get("hospital-other total expenditure")).intValue());// sewerage total expenditure
            this.sewerageTotalExpenditure = new Integer(((Long)json_data.get("sewerage total expenditure")).intValue());// direct expenditure
            this.directExpenditure = new Integer(((Long)json_data.get("direct expenditure")).intValue());// federal veteran's education intergovernmental
            this.federalVeteransEducationIntergovernmental = new Integer(((Long)json_data.get("federal veteran's education intergovernmental")).intValue());// federal agriculture farm income intergovernmental
            this.federalAgricultureFarmIncomeIntergovernmental = new Integer(((Long)json_data.get("federal agriculture farm income intergovernmental")).intValue());// police intergovernmental
            this.policeIntergovernmental = new Integer(((Long)json_data.get("police intergovernmental")).intValue());// general equipment only
            this.generalEquipmentOnly = new Integer(((Long)json_data.get("general equipment only")).intValue());// correction  intergovernmental
            this.correctionIntergovernmental = new Integer(((Long)json_data.get("correction  intergovernmental")).intValue());// cash and deposits total
            this.cashAndDepositsTotal = new Integer(((Long)json_data.get("cash and deposits total")).intValue());// education construction
            this.educationConstruction = new Integer(((Long)json_data.get("education construction")).intValue());// insurance trust securities total
            this.insuranceTrustSecuritiesTotal = new Integer(((Long)json_data.get("insurance trust securities total")).intValue());// intergovernmental expenditure
            this.intergovernmentalExpenditure = new Integer(((Long)json_data.get("intergovernmental expenditure")).intValue());// fish and game intergovernmental
            this.fishAndGameIntergovernmental = new Integer(((Long)json_data.get("fish and game intergovernmental")).intValue());// public welfare assistance and subsidies
            this.publicWelfareAssistanceAndSubsidies = new Integer(((Long)json_data.get("public welfare assistance and subsidies")).intValue());// general interest total expenditure
            this.generalInterestTotalExpenditure = new Integer(((Long)json_data.get("general interest total expenditure")).intValue());// protective inspection intergovernmental
            this.protectiveInspectionIntergovernmental = new Integer(((Long)json_data.get("protective inspection intergovernmental")).intValue());// correction nec total
            this.correctionNecTotal = new Integer(((Long)json_data.get("correction nec total")).intValue());// intergovernmental to counties
            this.intergovernmentalToCounties = new Integer(((Long)json_data.get("intergovernmental to counties")).intValue());// veteran's affairs total expenditure
            this.veteransAffairsTotalExpenditure = new Integer(((Long)json_data.get("veteran's affairs total expenditure")).intValue());// interest on general debt
            this.interestOnGeneralDebt = new Integer(((Long)json_data.get("interest on general debt")).intValue());// hospitals total expenditure
            this.hospitalsTotalExpenditure = new Integer(((Long)json_data.get("hospitals total expenditure")).intValue());// general support total expenditure
            this.generalSupportTotalExpenditure = new Integer(((Long)json_data.get("general support total expenditure")).intValue());// highways intergovernmental
            this.highwaysIntergovernmental = new Integer(((Long)json_data.get("highways intergovernmental")).intValue());// sewerage intergovernmental
            this.sewerageIntergovernmental = new Integer(((Long)json_data.get("sewerage intergovernmental")).intValue());// federal own veteran's hospital intergovernmental
            this.federalOwnVeteransHospitalIntergovernmental = new Integer(((Long)json_data.get("federal own veteran's hospital intergovernmental")).intValue());// highways land and equipment
            this.highwaysLandAndEquipment = new Integer(((Long)json_data.get("highways land and equipment")).intValue());// utilities equipment and land
            this.utilitiesEquipmentAndLand = new Integer(((Long)json_data.get("utilities equipment and land")).intValue());// long term debt-nt total
            this.longTermDebtNtTotal = new Integer(((Long)json_data.get("long term debt-nt total")).intValue());// federal farm credit intergovernmental
            this.federalFarmCreditIntergovernmental = new Integer(((Long)json_data.get("federal farm credit intergovernmental")).intValue());// bond fund total
            this.bondFundTotal = new Integer(((Long)json_data.get("bond fund total")).intValue());// electric utility total expenditure
            this.electricUtilityTotalExpenditure = new Integer(((Long)json_data.get("electric utility total expenditure")).intValue());// natural resources intergovernmental
            this.naturalResourcesIntergovernmental = new Integer(((Long)json_data.get("natural resources intergovernmental")).intValue());// sinking fund total
            this.sinkingFundTotal = new Integer(((Long)json_data.get("sinking fund total")).intValue());// education equipment
            this.educationEquipment = new Integer(((Long)json_data.get("education equipment")).intValue());// intergovernmental to state
            this.intergovernmentalToState = new Integer(((Long)json_data.get("intergovernmental to state")).intValue());// utilities current operation
            this.utilitiesCurrentOperation = new Integer(((Long)json_data.get("utilities current operation")).intValue());// forestry intergovernmental
            this.forestryIntergovernmental = new Integer(((Long)json_data.get("forestry intergovernmental")).intValue());// intergovernmental to special districts
            this.intergovernmentalToSpecialDistricts = new Integer(((Long)json_data.get("intergovernmental to special districts")).intValue());// utilities total expenditure
            this.utilitiesTotalExpenditure = new Integer(((Long)json_data.get("utilities total expenditure")).intValue());// federal agency securities total
            this.federalAgencySecuritiesTotal = new Integer(((Long)json_data.get("federal agency securities total")).intValue());// general assistance and subsidies
            this.generalAssistanceAndSubsidies = new Integer(((Long)json_data.get("general assistance and subsidies")).intValue());// utilities construction
            this.utilitiesConstruction = new Integer(((Long)json_data.get("utilities construction")).intValue());// public welfare total expenditure
            this.publicWelfareTotalExpenditure = new Integer(((Long)json_data.get("public welfare total expenditure")).intValue());// securities total
            this.securitiesTotal = new Integer(((Long)json_data.get("securities total")).intValue());// correction institutions total
            this.correctionInstitutionsTotal = new Integer(((Long)json_data.get("correction institutions total")).intValue());// long term debt issued-unsp total
            this.longTermDebtIssuedUnspTotal = new Integer(((Long)json_data.get("long term debt issued-unsp total")).intValue());// insurance trust federal  securities
            this.insuranceTrustFederalSecurities = new Integer(((Long)json_data.get("insurance trust federal  securities")).intValue());// employee retirement total expenditure
            this.employeeRetirementTotalExpenditure = new Integer(((Long)json_data.get("employee retirement total expenditure")).intValue());// public welfare equipment and land
            this.publicWelfareEquipmentAndLand = new Integer(((Long)json_data.get("public welfare equipment and land")).intValue());// intergovernmental to municipalities
            this.intergovernmentalToMunicipalities = new Integer(((Long)json_data.get("intergovernmental to municipalities")).intValue());// noninsurance trust cash and securities total
            this.noninsuranceTrustCashAndSecuritiesTotal = new Integer(((Long)json_data.get("noninsurance trust cash and securities total")).intValue());// forestry total expenditure
            this.forestryTotalExpenditure = new Integer(((Long)json_data.get("forestry total expenditure")).intValue());// worker's comp total cash and securities
            this.workersCompTotalCashAndSecurities = new Integer(((Long)json_data.get("worker's comp total cash and securities")).intValue());// health total expenditure
            this.healthTotalExpenditure = new Integer(((Long)json_data.get("health total expenditure")).intValue());// cash and securities total
            this.cashAndSecuritiesTotal = new Integer(((Long)json_data.get("cash and securities total")).intValue());// fire protection total expenditure
            this.fireProtectionTotalExpenditure = new Integer(((Long)json_data.get("fire protection total expenditure")).intValue());// hospitals total construction
            this.hospitalsTotalConstruction = new Integer(((Long)json_data.get("hospitals total construction")).intValue());// agriculture total expenditure
            this.agricultureTotalExpenditure = new Integer(((Long)json_data.get("agriculture total expenditure")).intValue());// solid waste management intergovernmental
            this.solidWasteManagementIntergovernmental = new Integer(((Long)json_data.get("solid waste management intergovernmental")).intValue());// long term debt issued total
            this.longTermDebtIssuedTotal = new Integer(((Long)json_data.get("long term debt issued total")).intValue());// utilities interest total
            this.utilitiesInterestTotal = new Integer(((Long)json_data.get("utilities interest total")).intValue());// education intergovernmental
            this.educationIntergovernmental = new Integer(((Long)json_data.get("education intergovernmental")).intValue());// federal national defense intergovernmental
            this.federalNationalDefenseIntergovernmental = new Integer(((Long)json_data.get("federal national defense intergovernmental")).intValue());// intergovernmental to federal
            this.intergovernmentalToFederal = new Integer(((Long)json_data.get("intergovernmental to federal")).intValue());// current operation
            this.currentOperation = new Integer(((Long)json_data.get("current operation")).intValue());// education-nec expenditure total
            this.educationNecExpenditureTotal = new Integer(((Long)json_data.get("education-nec expenditure total")).intValue());// welfare nec total expenditure
            this.welfareNecTotalExpenditure = new Integer(((Long)json_data.get("welfare nec total expenditure")).intValue());// long term debt retired total
            this.longTermDebtRetiredTotal = new Integer(((Long)json_data.get("long term debt retired total")).intValue());// correction  total
            this.correctionTotal = new Integer(((Long)json_data.get("correction  total")).intValue());// education equipment and land
            this.educationEquipmentAndLand = new Integer(((Long)json_data.get("education equipment and land")).intValue());// noninsurance trust cash and deposits total
            this.noninsuranceTrustCashAndDepositsTotal = new Integer(((Long)json_data.get("noninsurance trust cash and deposits total")).intValue());// financial administration intergovernmental
            this.financialAdministrationIntergovernmental = new Integer(((Long)json_data.get("financial administration intergovernmental")).intValue());// employee retirement total cash and securities
            this.employeeRetirementTotalCashAndSecurities = new Integer(((Long)json_data.get("employee retirement total cash and securities")).intValue());// other insurance trust
            this.otherInsuranceTrust = new Integer(((Long)json_data.get("other insurance trust")).intValue());// fish and game total expenditure
            this.fishAndGameTotalExpenditure = new Integer(((Long)json_data.get("fish and game total expenditure")).intValue());// federal health-veterans intergovernmental
            this.federalHealthVeteransIntergovernmental = new Integer(((Long)json_data.get("federal health-veterans intergovernmental")).intValue());// cash assistance intergovernmental
            this.cashAssistanceIntergovernmental = new Integer(((Long)json_data.get("cash assistance intergovernmental")).intValue());// federal own veteran's hospitalstotal
            this.federalOwnVeteransHospitalstotal = new Integer(((Long)json_data.get("federal own veteran's hospitalstotal")).intValue());// protective inspection total expenditure
            this.protectiveInspectionTotalExpenditure = new Integer(((Long)json_data.get("protective inspection total expenditure")).intValue());// other insurance trust total cash and securities
            this.otherInsuranceTrustTotalCashAndSecurities = new Integer(((Long)json_data.get("other insurance trust total cash and securities")).intValue());// noninsurance trust state and local securities total
            this.noninsuranceTrustStateAndLocalSecuritiesTotal = new Integer(((Long)json_data.get("noninsurance trust state and local securities total")).intValue());// categorical assistance total expenditure
            this.categoricalAssistanceTotalExpenditure = new Integer(((Long)json_data.get("categorical assistance total expenditure")).intValue());// insurance trust total expenditure
            this.insuranceTrustTotalExpenditure = new Integer(((Long)json_data.get("insurance trust total expenditure")).intValue());// general control total
            this.generalControlTotal = new Integer(((Long)json_data.get("general control total")).intValue());// public welfare other current operation
            this.publicWelfareOtherCurrentOperation = new Integer(((Long)json_data.get("public welfare other current operation")).intValue());// public welfare construction
            this.publicWelfareConstruction = new Integer(((Long)json_data.get("public welfare construction")).intValue());// federal treasury securities total
            this.federalTreasurySecuritiesTotal = new Integer(((Long)json_data.get("federal treasury securities total")).intValue());// educationother current operation
            this.educationotherCurrentOperation = new Integer(((Long)json_data.get("educationother current operation")).intValue());// federal space research intergovernmental
            this.federalSpaceResearchIntergovernmental = new Integer(((Long)json_data.get("federal space research intergovernmental")).intValue());// judicial intergovernmental
            this.judicialIntergovernmental = new Integer(((Long)json_data.get("judicial intergovernmental")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}