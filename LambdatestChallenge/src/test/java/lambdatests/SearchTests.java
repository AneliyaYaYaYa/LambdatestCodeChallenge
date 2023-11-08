package lambdatests;

import core.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SearchTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({"ipod", "ipod nano", "ipo", "HTC", "hTc"})
    public void searchShowsResult_when_searchedWithValidTerms(String item) {
        homePage.navigateToPage();
        homePage.searchForItem(item);
        searchPage.verifySearchPageNavigated(item);
        searchPage.verifySearchResults(item);
    }


}
