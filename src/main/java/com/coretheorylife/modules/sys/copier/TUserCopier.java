package com.coretheorylife.modules.sys.copier;

import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.ext.ExtTUser;
import com.coretheorylife.modules.sys.vo.TUserRVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TUserCopier {
    TUserCopier INSTANCE = Mappers.getMapper(TUserCopier.class);

    TUser asSysBanner(TUserRVO bean);

    TUserRVO asTUserRVO(TUser bean);

    List<TUserRVO> asTUserRVOList(List<TUser> bean);

    TUserRVO asTUserRVOExt(ExtTUser bean);

    List<TUserRVO> asTUserRVOListExt(List<ExtTUser> bean);
}
