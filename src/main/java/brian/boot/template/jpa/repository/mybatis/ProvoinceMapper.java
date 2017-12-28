package brian.boot.template.jpa.repository.mybatis;

import brian.boot.template.jpa.domain.mybatis.Province;

import java.util.List;

public interface ProvoinceMapper {

//    @Select("select provinceId, name from Province")
    Province findByProvinceCode(int provinceCode);
    List<Province> findAllProvinces();
}
