package builder;

import candy.Candy_V1;
import candy.Candy_V2;
import candy.Candy_V3;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BuilderTest {

    @Test
    void shouldBuildV1Version() {
        //given
        Candy_V1.Builder builder =
                Candy_V1.builder(Candy_V1.Builder.class)
                        .setCost(1)
                        .setName("name");
        //when
        Candy_V1 candy = builder.build();
        //then
        assertThat(candy.getName()).isEqualTo("name");
    }

    @Test
    void shouldBuildV2VersionViaStaticMethod() {
        //given
        Candy_V2.Builder builder = Candy_V2.builder(Candy_V2.Builder.class)
                .setCost(1)
                .setV2Field("v2")
                .setName("name")
                .setV2Field("v2")
                .setName("name")
                .setV2Field("name");
        //when
        Candy_V2 candy = builder.build();
        //then
        assertThat(candy.getName()).isEqualTo("name");
        assertThat(candy.getV2Field()).isEqualTo("name");
    }

    @Test
    void shouldBuildV2VersionViaConstructor() {
        //given
        Candy_V2.Builder builder = new Candy_V2.Builder()
                .setCost(1)
                .setV2Field("v2")
                .setName("name")
                .setV2Field("v2")
                .setName("name")
                .setV2Field("name");
        //when
        Candy_V2 candy = builder.build();
        //then
        assertThat(candy.getName()).isEqualTo("name");
        assertThat(candy.getV2Field()).isEqualTo("name");
    }

    @Test
    void shouldBuildV3VersionViaStaticMethod() {
        //given
        Candy_V3.Builder builder = Candy_V1.builder(Candy_V3.Builder.class)
                .setName("name")
                .setCost(1)
                .setV2Field("v2")
                .setV3Field("v3");
        //when
        Candy_V3 candy = builder.build();
        //then
        assertThat(candy.getName()).isEqualTo("name");
        assertThat(candy.getV2Field()).isEqualTo("v2");
        assertThat(candy.getV3Field()).isEqualTo("v3");
    }

    @Test
    void shouldCallingOrderNotBrokenBuildObject() {
        //given
        Candy_V3 v3 = new Candy_V3.Builder().setCost(3).setName("v1_3").setV2Field("v2_3").setV3Field("v3_3").build();
        Candy_V3.Builder builder = Candy_V1.builder(Candy_V3.Builder.class)
                .setName("v1_1")
                .setCost(1)
                .setV2Field("v2_1")
                .setV3Field("v3_1")
                .setV2Field("v2_2")
                .setCost(2)
                .setV3Field("v3_2")
                .setName("v1_2")
                .setV3Field("v3_3")
                .setCost(3)
                .setV2Field("v2_3")
                .setName("v1_3");

        //when
        Candy_V3 candy = builder.build();
        //then
        assertThat(candy.getName()).isEqualTo("v1_3");
        assertThat(candy.getCost()).isEqualTo(3);
        assertThat(candy.getV2Field()).isEqualTo("v2_3");
        assertThat(candy.getV3Field()).isEqualTo("v3_3");
        assertThat(v3).isEqualTo(candy);
    }
}
