package io.github.bhhan.service;

import io.github.bhhan.domain.Menu;
import io.github.bhhan.domain.Option;
import io.github.bhhan.domain.OptionGroup;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hbh5274@gmail.com on 2020-04-22
 * Github : http://github.com/bhhan5274
 */
public class MenuDto {

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MenuReq {
        @NotNull
        private Long id;

        @NotBlank
        private String name;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MenuFormReq {
        @NotBlank
        private String menuName;

        @Valid
        @NotNull
        private List<OptionGroupFormReq> optionGroupFormReqs;

        public Menu toEntity(){
            return Menu.builder()
                    .name(menuName)
                    .optionGroups(optionGroupFormReqs.stream()
                                    .map(OptionGroupFormReq::toEntity)
                                    .collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionGroupFormReq {
        @NotBlank
        private String optionGroupName;

        @NotNull
        @Valid
        private List<OptionFormReq> optionFormReqs;

        public OptionGroup toEntity(){
            return OptionGroup.builder()
                    .name(optionGroupName)
                    .options(optionFormReqs.stream()
                            .map(OptionFormReq::toEntity)
                            .collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionFormReq {
        @NotBlank
        private String optionName;

        @Min(1000)
        @Max(200000)
        private int optionAmount;

        public Option toEntity(){
            return Option.builder()
                    .name(optionName)
                    .amount(optionAmount)
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MenuRes {
        private Long id;
        private String name;
        private List<OptionGroupRes> optionGroupRes;

        public MenuRes(Menu menu){
            this.id = menu.getId();
            this.name = menu.getName();
            optionGroupRes = menu.getOptionGroups()
                    .stream()
                    .map(OptionGroupRes::new)
                    .collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionGroupRes {
        private Long id;
        private String name;
        private List<OptionRes> optionRes;

        public OptionGroupRes(OptionGroup optionGroup){
            this.id = optionGroup.getId();
            this.name = optionGroup.getName();
            this.optionRes = optionGroup.getOptions()
                    .stream()
                    .map(OptionRes::new)
                    .collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionRes {
        private Long id;
        private String name;
        private int amount;

        public OptionRes(Option option){
            this.id = option.getId();
            this.name = option.getName();
            this.amount = option.getAmount();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MenuUpdateReq {
        private Long id;
        private String name;
        private List<OptionGroupUpdateReq> optionGroups = new ArrayList<>();

        public Menu toEntity(){
            return Menu.builder()
                    .id(id)
                    .name(name)
                    .optionGroups(optionGroups.stream().map(OptionGroupUpdateReq::toEntity).collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionGroupUpdateReq {
        private Long id;
        private String name;
        private List<OptionUpdateReq> options = new ArrayList<>();

        public OptionGroup toEntity(){
            return OptionGroup.builder()
                    .id(id)
                    .name(name)
                    .options(options.stream().map(OptionUpdateReq::toEntity).collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OptionUpdateReq {
        private Long id;
        private String name;
        private int amount;

        public Option toEntity(){
            return Option.builder()
                    .id(id)
                    .name(name)
                    .amount(amount)
                    .build();
        }
    }
}
