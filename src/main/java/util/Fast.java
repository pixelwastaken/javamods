package util;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraftforge.common.util.Lazy;

final class Fast<T> implements Lazy<T>
{
    public Supplier<T> supplier;
    public T instance;
    public Fast(Supplier<T> supplier)
    {
        this.supplier = supplier;
    }

	@Nullable
    @Override
    public final T get()
    {
        if (supplier != null)
        {
            instance = supplier.get();
            supplier = null;
        }
        return instance;
    }
}
