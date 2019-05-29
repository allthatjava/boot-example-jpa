package brian.template.boot.jpa.repository.mybatis;

import java.util.List;

import brian.template.boot.jpa.domain.mybatis.Province;

public interface ProvoinceMapper {

//    @Select("select provinceId, name from Province")
    Province findByProvinceCode(int provinceCode);
    List<Province> findAllProvinces();
}
